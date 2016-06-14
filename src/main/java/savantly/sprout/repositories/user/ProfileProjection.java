package savantly.sprout.repositories.user;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ProfileProjection {
	@Value("#{target.primaryEmailAddress.emailAddress}")
	String getEmailAddress();
	@JsonIgnore
	String getPrimaryEmailAddress();
	String getUsername();
	String getDisplayName();
	@Value("#{target.getGravatarUrl()}")
	String getGravatarUrl();
}
