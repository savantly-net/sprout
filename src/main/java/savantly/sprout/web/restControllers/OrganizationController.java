package savantly.sprout.web.restControllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.Organization;
import savantly.sprout.domain.SproutUser;
import savantly.sprout.exceptions.UnknownUserException;
import savantly.sprout.repositories.organization.OrganizationRepository;
import savantly.sprout.viewModel.CommonResponse;
import savantly.sprout.viewModel.MemberViewModel;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/organizations")
public class OrganizationController extends ResourceController<Organization, String> {
	private static Logger log = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	public OrganizationController(OrganizationRepository entityRepository) {
		super(entityRepository);
	}
	
	@RequestMapping(path="/addMember",  method=RequestMethod.POST)
	public CommonResponse addMember(@RequestBody @Valid MemberViewModel model, @AuthenticationPrincipal SproutUser user){
		String message = "User is now a member of the organization";
		Object organization = null;
		try{
			organization = ((OrganizationRepository)this.getEntityRepository()).addMember(model.getOrganizationId(), model.getEmailAddress(), model.getPermission());
		} catch (UnknownUserException ex){
			log.info("UnknownUser: " + model.getEmailAddress());
			message = "Invited to organization: " + model.getEmailAddress();
		}
		CommonResponse response = new CommonResponse(message, organization);
		return response;
	}
}
