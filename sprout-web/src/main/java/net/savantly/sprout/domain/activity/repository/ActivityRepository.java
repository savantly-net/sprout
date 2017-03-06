package net.savantly.sprout.domain.activity.repository;

import net.savantly.sprout.domain.activity.Activity;
import net.savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface ActivityRepository extends ExtendedMongoRepository<Activity, String>{
	
}
