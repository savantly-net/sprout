package savantly.sprout.repositories.emailAddress;

import savantly.sprout.domain.EmailAddress;
import savantly.sprout.repositories.ExtendedMongoRepository;

public interface EmailAddressRepository extends ExtendedMongoRepository<EmailAddress, String>, EmailAddressRepositoryCustom {


}
