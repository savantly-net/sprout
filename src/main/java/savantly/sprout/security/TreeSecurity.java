package savantly.sprout.security;

import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.domain.Tree;

public interface TreeSecurity extends AuditedDomainSecurity<Tree, String>{

	CriteriaDefinition CriteriaForReading(SproutUser user);

}
