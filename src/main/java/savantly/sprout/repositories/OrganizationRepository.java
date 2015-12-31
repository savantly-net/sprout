package savantly.sprout.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import savantly.sprout.domain.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String>{

}
