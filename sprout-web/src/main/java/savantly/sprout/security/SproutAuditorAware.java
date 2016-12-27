package savantly.sprout.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import savantly.sprout.domain.user.SproutUser;

@Component
public class SproutAuditorAware implements AuditorAware<String> {

	  public String getCurrentAuditor() {

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication == null || !authentication.isAuthenticated()) {
	      return null;
	    }
	    
	    if(authentication.getPrincipal().getClass().isAssignableFrom(SproutUser.class)){
	    	return ((SproutUser)authentication.getPrincipal()).getId();
	    }
	    else{
	    	throw new RuntimeException("Security Principal is invalid");
	    }
	  }
	}