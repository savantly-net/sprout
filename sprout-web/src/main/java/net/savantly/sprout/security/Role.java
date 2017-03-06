package net.savantly.sprout.security;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -8442995033031637920L;
	private String authority;
	
	public Role(){}

	public Role(String authority) {
		this.authority = authority;
	}

	public Role(Roles role) {
		this.authority = role.name();
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Role [authority=" + authority + "]";
	}
	
}
