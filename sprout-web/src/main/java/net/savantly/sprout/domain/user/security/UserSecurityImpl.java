package net.savantly.sprout.domain.user.security;

import net.savantly.sprout.domain.user.SproutUser;
import net.savantly.sprout.security.AuditableSecurityAdapter;

public class UserSecurityImpl extends AuditableSecurityAdapter<SproutUser, String> implements UserSecurity {

}
