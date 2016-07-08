package savantly.sprout.domain.report.security;

import savantly.sprout.domain.report.UserActivity;
import savantly.sprout.security.AuditableSecurityAdapter;

public class UserActivitySecurityImpl extends AuditableSecurityAdapter<UserActivity, String> implements UserActivitySecurity {

}
