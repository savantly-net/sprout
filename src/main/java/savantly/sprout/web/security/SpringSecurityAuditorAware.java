package savantly.sprout.web.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import savantly.sprout.domain.SproutUser;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<SproutUser> {

	  public SproutUser getCurrentAuditor() {

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication == null || !authentication.isAuthenticated()) {
	      return null;
	    }

	    return (SproutUser) authentication.getPrincipal();
	  }
	}