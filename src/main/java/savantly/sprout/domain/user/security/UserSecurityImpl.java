package savantly.sprout.domain.user.security;

import savantly.sprout.domain.user.SproutUser;
import savantly.sprout.security.AuditableSecurityAdapter;

public class UserSecurityImpl extends AuditableSecurityAdapter<SproutUser, String> implements UserSecurity {

}
