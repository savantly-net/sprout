package savantly.sprout.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

@Component
public class SproutAuditorAware implements AuditorAware<String> {

	  public String getCurrentAuditor() {

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication == null || !authentication.isAuthenticated()) {
	      return null;
	    }
	    
	    if(!Strings.isNullOrEmpty(authentication.getName())){
	    	return authentication.getName();
	    }
	    else{
	    	throw new RuntimeException("Security Principal is invalid");
	    }
	  }
	}