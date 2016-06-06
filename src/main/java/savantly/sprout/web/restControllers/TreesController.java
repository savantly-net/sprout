package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
	Page<Tree> searchTrees(@PathVariable("query") String queryText, Pageable pageable) {
		Assert.hasText(queryText, "A query is required");
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(queryText.split(" "));
		Query query = TextQuery.queryText(criteria).sortByScore();
	    Page<Tree> trees = this.getEntityRepository().query(query, pageable);
	    return trees;
	  }


}
