package savantly.sprout.domain;

import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Entity
public class EmailAddress {

	@Id
	private String emailAddress;
	private boolean verified;
	
	public EmailAddress(){}
	
	public EmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public EmailAddress(String emailAddress, boolean verified) {
		this.emailAddress = emailAddress;
		this.verified = verified;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean confirmed) {
		this.verified = confirmed;
	}

}
