package savantly.sprout.domain.organization.repository;

import savantly.sprout.domain.organization.Organization;
import savantly.sprout.security.Permission;

public interface OrganizationRepositoryCustom {
	Organization addMember(String organizationId, String userId, Permission permission);
}
