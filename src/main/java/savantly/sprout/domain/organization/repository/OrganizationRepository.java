package savantly.sprout.domain.organization.repository;

import savantly.sprout.domain.organization.Organization;
import savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface OrganizationRepository extends ExtendedMongoRepository<Organization, String>, OrganizationRepositoryCustom {

}
