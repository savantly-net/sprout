package savantly.sprout.domain.organization.security;

import savantly.sprout.domain.organization.Organization;
import savantly.sprout.security.AuditableSecurityAdapter;

public class OrganizationSecurityImpl extends AuditableSecurityAdapter<Organization, String> implements OrganizationSecurity{

}
