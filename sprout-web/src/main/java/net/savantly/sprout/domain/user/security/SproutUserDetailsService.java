package net.savantly.sprout.domain.user.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.savantly.sprout.domain.user.SproutUser;

public interface SproutUserDetailsService extends UserDetailsService{
	
	SproutUser loadByEmailAddress(String emailAddress);

}
