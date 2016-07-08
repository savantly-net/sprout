package savantly.sprout.domain.tree.security;

import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import savantly.sprout.domain.tree.Tree;
import savantly.sprout.domain.user.SproutUser;
import savantly.sprout.security.AuditedDomainSecurity;

public interface TreeSecurity extends AuditedDomainSecurity<Tree, String>{

	CriteriaDefinition CriteriaForReading(SproutUser user);

}
