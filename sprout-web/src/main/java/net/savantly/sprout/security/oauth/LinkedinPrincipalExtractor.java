package net.savantly.sprout.security.oauth;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

import net.savantly.sprout.domain.emailAddress.EmailAddress;
import net.savantly.sprout.domain.user.OAuthAccount;
import net.savantly.sprout.domain.user.SproutUser;
import net.savantly.sprout.domain.user.repository.UserRepository;
import net.savantly.sprout.domain.user.security.SproutUserDetailsService;

public class LinkedinPrincipalExtractor implements PrincipalExtractor {
	
	private UserRepository userRepository;
	private OAuth2RestTemplate restTemplate;
	private SproutUserDetailsService userDetailsService;

	public LinkedinPrincipalExtractor(UserRepository userRepository, SproutUserDetailsService userDetailsService, OAuth2RestTemplate oAuth2RestTemplate) {
		this.userRepository = userRepository;
		this.restTemplate = oAuth2RestTemplate;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	public Object extractPrincipal(Map<String, Object> authMap) {
		
		String emailString = (String)authMap.get("emailAddress");
		List<EmailAddress> emailList = Arrays.asList(new EmailAddress((String) emailString, false));
		String firstName = (String) authMap.getOrDefault("firstName", "Linkedin");
		String lastName = (String) authMap.getOrDefault("lastName", "User");
		OAuthAccount oAuthAccount = new OAuthAccount("linkedin", authMap);
		
		SproutUser user = userDetailsService.loadByEmailAddress(emailString.toLowerCase());
		
		if(user == null){
			return this.userRepository.getOrInsertForOAuth(firstName, lastName, oAuthAccount, emailList);
		}
		else {
			return user;
		}
		
	}
}
