package savantly.sprout.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import savantly.sprout.domain.SproutUserDetails;

public interface SproutUserDetailsRepository extends MongoRepository<SproutUserDetails, String>{

}
