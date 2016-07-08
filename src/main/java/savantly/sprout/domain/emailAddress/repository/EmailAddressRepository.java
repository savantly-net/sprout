package savantly.sprout.domain.emailAddress.repository;

import savantly.sprout.domain.emailAddress.EmailAddress;
import savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface EmailAddressRepository extends ExtendedMongoRepository<EmailAddress, String>, EmailAddressRepositoryCustom {


}
