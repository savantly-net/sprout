package savantly.sprout.domain.activity.repository;

import savantly.sprout.domain.activity.Activity;
import savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface ActivityRepository extends ExtendedMongoRepository<Activity, String>{
	
}
