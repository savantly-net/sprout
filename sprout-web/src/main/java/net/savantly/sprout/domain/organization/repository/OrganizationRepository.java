package net.savantly.sprout.domain.organization.repository;

import net.savantly.sprout.domain.organization.Organization;
import net.savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface OrganizationRepository extends ExtendedMongoRepository<Organization, String>, OrganizationRepositoryCustom {

}
