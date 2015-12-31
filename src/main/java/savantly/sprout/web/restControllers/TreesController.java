package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.domain.Tree;
import savantly.sprout.repositories.TreeRepository;
import savantly.sprout.web.angular.ResourceController;
import savantly.sprout.web.security.Roles;

@RestController
@RequestMapping("/rest/trees")
public class TreesController extends ResourceController<Tree, String> {
	
	@Autowired
	public TreesController(TreeRepository entityRepository) {
		super(entityRepository);
	}
	
	@Override
	protected boolean canCreate(Tree model, SproutUser user) {
		return this.isUserInRole(Roles.ROLE_USER);
	}


}
