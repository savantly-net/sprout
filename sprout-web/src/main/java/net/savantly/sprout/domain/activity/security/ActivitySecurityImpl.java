package net.savantly.sprout.domain.activity.security;

import net.savantly.sprout.domain.activity.Activity;
import net.savantly.sprout.security.AuditableSecurityAdapter;

public class ActivitySecurityImpl extends AuditableSecurityAdapter<Activity, String> implements ActivitySecurity {

}
