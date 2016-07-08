package savantly.sprout.web.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.tree.Tree;
import savantly.sprout.domain.tree.repository.TreeRepository;
import savantly.sprout.domain.tree.repository.TreeSummary;
import savantly.sprout.domain.tree.security.TreeSecurity;
import savantly.sprout.domain.user.SproutUser;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/trees")
public class TreesController extends ResourceController<Tree, String, TreeRepository> {
	
	@Autowired
	TreeSecurity treeSecurity;
	
	@Autowired
	public TreesController(TreeRepository entityRepository) {
		super(entityRepository);
	}
	
	@RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
	Page<Tree> searchTrees(@PathVariable("query") String queryText, Pageable pageable, @AuthenticationPrincipal SproutUser user) {
		Assert.hasText(queryText, "A query is required");
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(queryText.split(" "));
		Query query = TextQuery.queryText(criteria).sortByScore().addCriteria(treeSecurity.CriteriaForReading(user));
	    Page<Tree> trees = this.getEntityRepository().query(query, pageable);
	    return trees;
	  }
	
	@RequestMapping(value = "/summary/by/username/{username}", method = RequestMethod.GET)
	@PreAuthorize("@treeSecurity.canList()")
	List<TreeSummary> getTreeSummariesByUser(@PathVariable("username") String username){
		List<TreeSummary> trees = this.getEntityRepository().findTreeSummaryListByUsername(username);
		return trees;
	}


}
