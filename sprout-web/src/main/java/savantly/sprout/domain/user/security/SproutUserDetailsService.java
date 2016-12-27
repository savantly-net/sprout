package savantly.sprout.domain.user.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import savantly.sprout.domain.user.SproutUser;

public interface SproutUserDetailsService extends UserDetailsService{
	
	SproutUser loadByEmailAddress(String emailAddress);

}
