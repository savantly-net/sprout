package savantly.sprout.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import savantly.sprout.domain.SproutUser;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<SproutUser> {
	
	@Autowired
	SproutUserDetailsService userDetailsService;

	  public SproutUser getCurrentAuditor() {

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication == null || !authentication.isAuthenticated()) {
	      return null;
	    }
	    
	    if(authentication.getPrincipal() instanceof SproutUser){
	    	return (SproutUser) authentication.getPrincipal();
	    }
	    else if(authentication.getPrincipal() instanceof String){
            return (SproutUser) userDetailsService.loadUserByUsername((String) authentication.getPrincipal());
	    }
	    else{
	    	throw new RuntimeException("Security Principal is invalid");
	    }
	  }
	}