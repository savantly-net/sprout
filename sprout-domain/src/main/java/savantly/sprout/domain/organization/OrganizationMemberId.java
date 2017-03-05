package savantly.sprout.domain.organization;

import javax.persistence.Embeddable;

import org.springframework.data.mongodb.core.mapping.DBRef;

import savantly.sprout.domain.user.SproutUser;
import savantly.sprout.security.Permission;

@Embeddable
public class OrganizationMemberId {
	@DBRef
	SproutUser user;
	Permission permission;
	
	public OrganizationMemberId(){}
	
	public OrganizationMemberId(SproutUser user, Permission permission){
		this.user = user;
		this.permission = permission;
	}
	
	public SproutUser getUser() {
		return user;
	}
	public void setUser(SproutUser user) {
		this.user = user;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
