package savantly.sprout.repositories.organization;

import savantly.sprout.domain.Organization;
import savantly.sprout.domain.Permission;

public interface OrganizationRepositoryCustom {
	Organization addMember(String organizationId, String userId, Permission permission);
}
