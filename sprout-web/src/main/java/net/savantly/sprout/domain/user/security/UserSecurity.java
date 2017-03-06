package net.savantly.sprout.domain.user.security;

import net.savantly.sprout.domain.user.SproutUser;
import net.savantly.sprout.security.AuditedDomainSecurity;

public interface UserSecurity extends AuditedDomainSecurity<SproutUser, String>{

}
