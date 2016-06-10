package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import savantly.sprout.web.security.AbstractAuditableDomainObject;

public class Organization extends AbstractAuditableDomainObject<String> {

	private static final long serialVersionUID = -7810803525872806064L;

	@Id
	private String id;
	private String name;
	@DBRef
	private Set<OrganizationMember> members;
	
	public Organization(){
		this.members = new HashSet<OrganizationMember>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<OrganizationMember> getMembers() {
		return members;
	}

	public void setMembers(Set<OrganizationMember> members) {
		this.members = members;
	}
	
	public void addMember(OrganizationMember member){
		this.members.add(member);
	}
}
