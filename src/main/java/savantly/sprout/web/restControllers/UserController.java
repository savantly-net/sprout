package savantly.sprout.web.restControllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.repositories.UserRepository;
import savantly.sprout.web.angular.ResourceController;
import savantly.sprout.web.angular.ResourceEvent;
import savantly.sprout.web.security.ClientCredentials;
import savantly.sprout.web.security.Roles;

@RestController
@RequestMapping("/rest/users")
public class UserController extends ResourceController<SproutUser, String>{

	private UserRepository entityRepository;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	public UserController(UserRepository entityRepository) {
		super(entityRepository);
		this.entityRepository = entityRepository;
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
	protected boolean canUpdate(SproutUser model, SproutUser user) {
		if (model.getUsername().equals(user.getUsername()) || this.isUserInRole(Roles.ROLE_SUPERADMIN)) return true;
		else return false;
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public Object signUp(@RequestBody @Valid ClientCredentials credentials, @AuthenticationPrincipal SproutUser currentUser, HttpServletRequest request, HttpServletResponse response) {
		SproutUser model = new SproutUser(
				credentials.getUsername(), 
				credentials.getPassword(), 
				credentials.getFirstName(), 
				credentials.getLastName());
		model.setEmailAddress(credentials.getEmailAddress());
		SproutUser newUser = this.create(model, currentUser);
		
		UsernamePasswordAuthenticationToken newAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(newUser, "NA", newUser.getAuthorities());
    	SecurityContextHolder.getContext().setAuthentication(newAuthenticationToken);
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ((SproutUser)authentication.getPrincipal()).eraseCredentials();
        return newAuthenticationToken;
	}

}
