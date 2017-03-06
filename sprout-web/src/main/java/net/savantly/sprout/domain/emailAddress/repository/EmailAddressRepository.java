package net.savantly.sprout.domain.emailAddress.repository;

import net.savantly.sprout.domain.emailAddress.EmailAddress;
import net.savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface EmailAddressRepository extends ExtendedMongoRepository<EmailAddress, String>, EmailAddressRepositoryCustom {


}
