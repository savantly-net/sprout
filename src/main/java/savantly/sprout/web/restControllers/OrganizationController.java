package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.Organization;
import savantly.sprout.repositories.ExtendedMongoRepository;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/organizations")
public class OrganizationController extends ResourceController<Organization, String> {

	@Autowired
	public OrganizationController(ExtendedMongoRepository<Organization, String> entityRepository) {
		super(entityRepository);
	}

}
