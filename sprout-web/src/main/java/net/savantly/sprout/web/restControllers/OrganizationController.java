package net.savantly.sprout.web.restControllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.savantly.sprout.domain.organization.Organization;
import net.savantly.sprout.domain.organization.repository.OrganizationRepository;
import net.savantly.sprout.domain.user.SproutUser;
import net.savantly.sprout.domain.user.exception.UnknownUserException;
import net.savantly.sprout.web.angular.ResourceController;
import net.savantly.sprout.web.viewModel.CommonResponse;
import net.savantly.sprout.web.viewModel.MemberViewModel;

@RestController
@RequestMapping("/rest/organizations")
public class OrganizationController extends ResourceController<Organization, String, OrganizationRepository> {
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
			organization = this.getEntityRepository().addMember(model.getOrganizationId(), model.getEmailAddress(), model.getPermission());
		} catch (UnknownUserException ex){
			log.info("UnknownUser: " + model.getEmailAddress());
			message = "Invited to organization: " + model.getEmailAddress();
		}
		CommonResponse response = new CommonResponse(message, organization);
		return response;
	}
}
