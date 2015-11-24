package savantly.sprout.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import savantly.sprout.domain.UserActivity;

public interface UserActivityRepository extends MongoRepository<UserActivity, String>{

}
