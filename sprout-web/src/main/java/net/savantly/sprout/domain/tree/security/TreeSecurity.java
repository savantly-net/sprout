package net.savantly.sprout.domain.tree.security;

import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import net.savantly.sprout.domain.tree.Tree;
import net.savantly.sprout.domain.user.SproutUser;
import net.savantly.sprout.security.AuditedDomainSecurity;

public interface TreeSecurity extends AuditedDomainSecurity<Tree, String>{

	CriteriaDefinition CriteriaForReading(SproutUser user);

}
