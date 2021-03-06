package net.savantly.sprout.domain.user.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import net.savantly.sprout.domain.emailAddress.EmailAddress;
import net.savantly.sprout.domain.emailAddress.repository.EmailAddressRepository;
import net.savantly.sprout.domain.user.SproutUser;
import net.savantly.sprout.domain.user.repository.UserRepository;
import net.savantly.sprout.security.Role;
import net.savantly.sprout.security.Roles;

@Component
public class SproutUserDetailsServiceImpl implements SproutUserDetailsService, InitializingBean {
	
	String anonymousUserName = "anonymousUser";
	String defaultUsername = "user";
	String adminUsername = "admin";
	String defaultPassword = "password";

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailAddressRepository emailAddressRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		username = Strings.isNullOrEmpty(username) ? anonymousUserName : username;
		SproutUser user = userRepository.findOneByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("User not found: %s", username));
		}
		else{
			return user;
		}
	}
	
	@Override
	public SproutUser loadByEmailAddress(String emailAddress) {
		return userRepository.findByEmailAddress(emailAddress);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
        try{
        	loadUserByUsername("anonymousUser");
        } catch (UsernameNotFoundException ex){
        	List<Role> authorities = new ArrayList<Role>(1);
            authorities.add(new Role(Roles.ROLE_ANONYMOUS));
            SproutUser userDetails = new SproutUser(anonymousUserName, "", "Anonymous", "User", authorities);
            
            EmailAddress emailAddress = new EmailAddress("anonymous@savantly.net");
            emailAddressRepository.insert(emailAddress);
            
            userDetails.addEmailAddress(emailAddress);
            userRepository.save(userDetails);
        }
        
        
        try{
        	loadUserByUsername("admin");
        } catch (UsernameNotFoundException ex){
        	List<Role> authorities = new ArrayList<Role>(1);
            authorities.add(new Role(Roles.ROLE_ADMIN));
            SproutUser userDetails = new SproutUser(adminUsername, passwordEncoder.encode(defaultPassword), "Admin",  "User", authorities);
            
            EmailAddress emailAddress = new EmailAddress("admin@savantly.net");
            emailAddressRepository.insert(emailAddress);
            
            userDetails.addEmailAddress(emailAddress);
            userRepository.save(userDetails);
        }
	}

}
