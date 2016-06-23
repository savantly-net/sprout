package savantly.sprout.web.restControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.EmailAddress;
import savantly.sprout.domain.SproutUser;
import savantly.sprout.repositories.emailAddress.EmailAddressRepository;
import savantly.sprout.repositories.user.ProfileProjection;
import savantly.sprout.repositories.user.UserRepository;
import savantly.sprout.repositories.user.exception.EmailIsAlreadyRegisteredException;
import savantly.sprout.security.ClientCredentials;
import savantly.sprout.security.Roles;
import savantly.sprout.web.angular.ResourceController;
import savantly.sprout.web.angular.ResourceEvent;
import savantly.sprout.web.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/rest/users")
public class UserController extends ResourceController<SproutUser, String, UserRepository>{
	
	@Autowired
	EmailAddressRepository emailAddressRepository;

	private UserRepository entityRepository;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	public UserController(UserRepository entityRepository) {
		super(entityRepository);
		this.entityRepository = entityRepository;
	}
	
	@Override
	public SproutUser get(String id, SproutUser user) {
		return super.get(id, user);
	}
	
	@Override
	protected ResourceEvent<SproutUser> onUpdating(ResourceEvent<SproutUser> resourceEvent) {
		entityRepository.updatePartial(resourceEvent.getEntity(), resourceEvent.getEntity().getId());
		resourceEvent.setHandled(true);
		return resourceEvent;
	}

	@Override
	protected SproutUser onFindOne(SproutUser model) {
		// Stripping password before sending the user back
		if(model != null){
			model.eraseCredentials();
		}
		return model;
	}
	
	@Override
	protected boolean canCreate(SproutUser model, SproutUser user) {
		if(this.isUserInRole(Roles.ROLE_SUPERADMIN)) return true;
		else if (!model.getAuthorities().isEmpty()) return false;
		else if (entityRepository.exists(model.getUsername())) throw new RuntimeException("Username already exists");
		else return true;
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	protected boolean canList(SproutUser user) {
		return super.canList(user);
	}
	
	@Override
	protected boolean canUpdate(SproutUser model, SproutUser currentUser) {
		if (model.getUsername().equals(currentUser.getUsername()) || this.isUserInRole(Roles.ROLE_SUPERADMIN)) return true;
		else return false;
	}
	
	@PreAuthorize("isAnonymous()")
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public Object signUp(@RequestBody @Valid ClientCredentials credentials, @AuthenticationPrincipal SproutUser currentUser, HttpServletRequest request, HttpServletResponse response) 
			throws EmailIsAlreadyRegisteredException {
		
		String emailAddressString = credentials.getEmailAddress();
		EmailAddress emailAddress = emailAddressRepository.findOne(emailAddressString);
		if(emailAddress != null){
			throw new EmailIsAlreadyRegisteredException();
		} else{
			emailAddress = new EmailAddress(emailAddressString);
		}
		
		SproutUser model = new SproutUser(
				credentials.getUsername(), 
				credentials.getPassword(), 
				credentials.getFirstName(), 
				credentials.getLastName());
		model.addEmailAddress(emailAddress);
		SproutUser newUser = this.create(model, currentUser);
		
		
		UsernamePasswordAuthenticationToken newAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(newUser, "NA", newUser.getAuthorities());
    	SecurityContextHolder.getContext().setAuthentication(newAuthenticationToken);
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ((SproutUser)authentication.getPrincipal()).eraseCredentials();
        return newAuthenticationToken;
	}
	
	@RequestMapping(value={"/profile/{username}"},method = RequestMethod.GET)
	public ProfileProjection getProfile(@PathVariable String username){
		ProfileProjection profile = entityRepository.findProfileFirstByUsername(username);
		if(profile == null) 
			throw new ResourceNotFoundException();
		
		return profile;
	}
	
	@PreAuthorize("#currentUser.username == #myAccount.username")
	@RequestMapping(value={"/profile"},method = RequestMethod.PUT)
	public SproutUser updateProfile(@RequestBody SproutUser myAccount, @AuthenticationPrincipal SproutUser currentUser){
		if(myAccount == null) 
			throw new ResourceNotFoundException();
		
		return entityRepository.updateMyProfile(myAccount);
	}

}
