package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.Tree;
import savantly.sprout.repositories.TreeRepository;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/trees")
public class TreesController extends ResourceController<Tree> {
	
	@Autowired
	public TreesController(TreeRepository entityRepository) {
		super(entityRepository);
	}
}
