package savantly.sprout.domain;

import javax.persistence.EmbeddedId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrganizationMember {
	@EmbeddedId
	OrganizationMemberId id;
	
	public OrganizationMember(){}
	
	public OrganizationMember(OrganizationMemberId id){
		this.id = id;
	}

	public OrganizationMemberId getId() {
		return id;
	}

	public void setId(OrganizationMemberId id) {
		this.id = id;
	}
}
