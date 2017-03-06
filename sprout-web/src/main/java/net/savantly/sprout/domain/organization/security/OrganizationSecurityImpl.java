package net.savantly.sprout.domain.organization.security;

import net.savantly.sprout.domain.organization.Organization;
import net.savantly.sprout.security.AuditableSecurityAdapter;

public class OrganizationSecurityImpl extends AuditableSecurityAdapter<Organization, String> implements OrganizationSecurity{

}
