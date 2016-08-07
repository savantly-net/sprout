package savantly.sprout.domain.activity.security;

import savantly.sprout.domain.activity.Activity;
import savantly.sprout.security.AuditableSecurityAdapter;

public class ActivitySecurityImpl extends AuditableSecurityAdapter<Activity, String> implements ActivitySecurity {

}
