package savantly.sprout.domain;

import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Entity
public class EmailAddress {

	@Id
	private String emailAddress;
	private boolean confirmed;
	
	public EmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}
