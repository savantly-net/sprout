package savantly.sprout.domain.user.repository;

import org.springframework.data.mongodb.repository.Query;

import savantly.sprout.domain.user.SproutUser;
import savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface UserRepository extends ExtendedMongoRepository<SproutUser, String>, UserRepositoryCustom {

	ProfileProjection findProfileFirstByUsername(String username);
	SproutUser findOneByUsername(String username);
	SproutUser findByPrimaryEmailAddress_EmailAddress(String emailAddress);
	@Query("{'emailAddresses': { $elemMatch: { $id: ?0 }}}")
	SproutUser findByEmailAddress(String emailAddress);
}
