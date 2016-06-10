package savantly.sprout.repositories.user;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.repositories.ExtendedMongoRepository;

public interface UserRepository extends ExtendedMongoRepository<SproutUser, String>, UserRepositoryCustom {

}
