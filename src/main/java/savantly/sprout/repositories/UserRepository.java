package savantly.sprout.repositories;

import savantly.sprout.domain.SproutUser;

public interface UserRepository extends ExtendedMongoRepository<SproutUser, String>, UserRepositoryCustom {

}
