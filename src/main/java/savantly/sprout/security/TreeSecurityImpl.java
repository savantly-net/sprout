package savantly.sprout.security;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import savantly.sprout.domain.QTree;
import savantly.sprout.domain.SproutUser;
import savantly.sprout.domain.Tree;

public class TreeSecurityImpl extends AuditableSecurityAdapter<Tree, String> implements TreeSecurity {
	
	QTree tree = QTree.tree;
	
	Predicate<Tree> canViewTree = new Predicate<Tree>(){
		public boolean test(Tree t) {
			boolean readable = t.getIsPublic();
			// If the tree is public
			if(readable) return true;
			// if the current user created the tree
			else if (t.getCreatedBy().equals(getCurrentUser().getUsername())) return true;
			// if the current user is a member of the organization the tree is associated to
			else if (t.getOrganization().getMembers().contains(getCurrentUser())) return true;
			// otherwise reject access
			else return false;
		};
	};

	@Override
	public List<Tree> filter(List<Tree> list) {
		return list.stream().filter(t -> canViewTree.test(t))
				.collect(Collectors.toList());
	}

	@Override
	public CriteriaDefinition CriteriaForReading(SproutUser user) {
		user = user != null ? user : getCurrentUser();
		Criteria criteria = where("createdBy").is(user.getUsername())
				.orOperator(where("organization").in(user.getOrganizations().toArray()));
		return criteria;
	}
}
