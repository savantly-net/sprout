package savantly.sprout.domain.emailAddress;

import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

@Document
@Entity
public class EmailAddress {

	@Id
	private String emailAddress;
	private boolean verified;
	
	public EmailAddress(){}
	
	public EmailAddress(String emailAddress) {
		this(emailAddress, false);
	}
	
	public EmailAddress(String emailAddress, boolean verified) {
		Assert.hasText(emailAddress);
		this.emailAddress = emailAddress.toLowerCase();
		this.verified = verified;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		Assert.hasText(emailAddress);
		this.emailAddress = emailAddress.toLowerCase();
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean confirmed) {
		this.verified = confirmed;
	}

}
