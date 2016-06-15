package savantly.sprout.repositories.organization;

import savantly.sprout.domain.Organization;
import savantly.sprout.security.Permission;

public interface OrganizationRepositoryCustom {
	Organization addMember(String organizationId, String userId, Permission permission);
}
