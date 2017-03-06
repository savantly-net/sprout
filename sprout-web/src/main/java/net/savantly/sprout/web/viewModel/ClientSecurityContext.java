package net.savantly.sprout.web.viewModel;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class ClientSecurityContext {
	
	boolean isAnonymous;
	boolean isAuthenticated;
	boolean isFullyAuthenticated;
	boolean isRememberMe;
	Object principal;
	Collection<? extends GrantedAuthority> authorities;
	
	public boolean isAnonymous() {
		return isAnonymous;
	}
	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	public boolean isFullyAuthenticated() {
		return isFullyAuthenticated;
	}
	public void setFullyAuthenticated(boolean isFullyAuthenticated) {
		this.isFullyAuthenticated = isFullyAuthenticated;
	}
	public boolean isRememberMe() {
		return isRememberMe;
	}
	public void setRememberMe(boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}
	public Object getPrincipal() {
		return principal;
	}
	public void setPrincipal(Object principal) {
		this.principal = principal;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> collection) {
		this.authorities = collection;
	}
	

}
