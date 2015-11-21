package savantly.sprout.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import savantly.sprout.domain.SproutUser;

public interface UserRepository extends MongoRepository<SproutUser, String>{

}
