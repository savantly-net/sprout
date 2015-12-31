package savantly.sprout.domain;

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
	private Set<SproutUser> members;

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

	public Set<SproutUser> getMembers() {
		return members;
	}

	public void setMembers(Set<SproutUser> members) {
		this.members = members;
	}
}
