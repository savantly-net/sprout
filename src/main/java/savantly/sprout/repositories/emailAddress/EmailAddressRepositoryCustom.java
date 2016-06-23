package savantly.sprout.repositories.emailAddress;

import java.util.Collection;
import java.util.List;

import savantly.sprout.domain.EmailAddress;

public interface EmailAddressRepositoryCustom {
	List<EmailAddress> findOrInsert(Collection<EmailAddress> emailAddresses);
}
