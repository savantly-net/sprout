package net.savantly.sprout.domain.organization.repository;

import net.savantly.sprout.domain.organization.Organization;
import net.savantly.sprout.security.Permission;

public interface OrganizationRepositoryCustom {
	Organization addMember(String organizationId, String userId, Permission permission);
}
