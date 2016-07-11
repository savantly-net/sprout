package savantly.sprout.security;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import savantly.sprout.domain.user.SproutUser;

public abstract class AuditableSecurityAdapter<T extends 
			AbstractAuditableDomainObject<ID>, ID extends Serializable> implements AuditedDomainSecurity<T, ID>{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	final protected SproutUser getCurrentUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal.getClass().isAssignableFrom(SproutUser.class)){
			return (SproutUser) principal;
		}
		else return (SproutUser) userDetailsService.loadUserByUsername((String) principal);
	}
	
	@Override
	public boolean canCreate(T t) {
		if(getCurrentUser().hasRole(Roles.ROLE_ANONYMOUS)){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean canList() {
		return true;
	}
	
	@Override
	public boolean canUpdate(T t) {
		return t.getCreatedBy().equals(getCurrentUser().getId());
	}
	
	@Override
	public boolean canDelete(T t) {
		return t.getCreatedBy().equals(getCurrentUser().getId());
	}

	@Override
	public T filter(T t) {
		return t;
	}

	@Override
	public Page<T> filter(Page<T> page) {
		return page;
	}

	@Override
	public List<T> filter(List<T> list) {
		return list;
	}

}
