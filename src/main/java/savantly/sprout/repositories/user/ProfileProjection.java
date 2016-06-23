package savantly.sprout.repositories.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import savantly.sprout.domain.EmailAddress;

@JsonDeserialize(as=ProfileProjectionImpl.class)
public interface ProfileProjection {
	EmailAddress getPrimaryEmailAddress();
	List<EmailAddress> getEmailAddresses();
	String getUsername();
	String getDisplayName();
	@Value("#{target.getGravatarUrl()}")
	String getGravatarUrl();
}
