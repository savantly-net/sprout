package savantly.sprout.domain.emailAddress.repository;

import java.util.Collection;
import java.util.List;

import savantly.sprout.domain.emailAddress.EmailAddress;

public interface EmailAddressRepositoryCustom {
	List<EmailAddress> findOrInsert(Collection<EmailAddress> emailAddresses);
}
