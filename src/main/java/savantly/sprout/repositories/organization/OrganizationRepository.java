package savantly.sprout.repositories.organization;

import savantly.sprout.domain.Organization;
import savantly.sprout.repositories.ExtendedMongoRepository;

public interface OrganizationRepository extends ExtendedMongoRepository<Organization, String>, OrganizationRepositoryCustom {

}
