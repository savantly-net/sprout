package net.savantly.sprout.domain.emailAddress.repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import net.savantly.sprout.domain.emailAddress.EmailAddress;

public class EmailAddressRepositoryImpl implements EmailAddressRepositoryCustom{
	
	@Autowired
	MongoOperations mongoOperations;

	@Override
	public List<EmailAddress> findOrInsert(Collection<EmailAddress> emailAddresses) {		
		for (EmailAddress emailAddress : emailAddresses) {
			Query query = Query.query(Criteria.where("emailAddress").is(emailAddress.getEmailAddress()));
			
			Update update = Update.update("verified", emailAddress.isVerified());
			mongoOperations.upsert(query, update, EmailAddress.class).getUpsertedId();
		}
		return emailAddresses.stream().collect(Collectors.toList());
	}

}
