package savantly.sprout.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.repositories.user.UserRepository;

@Component
public class SproutUserDetailsService implements UserDetailsService, InitializingBean {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SproutUser user = userRepository.findOne(username);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("User not found: %s", username));
		}
		else{
			return user;
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
        try{
        	loadUserByUsername("anonymousUser");
        } catch (UsernameNotFoundException ex){
        	List<Role> authorities = new ArrayList<Role>(1);
            authorities.add(new Role(Roles.ROLE_ANONYMOUS));
            SproutUser userDetails = new SproutUser("anonymousUser", "", "Anonymous", "User", authorities);
            userRepository.save(userDetails);
        }
        
        try{
        	loadUserByUsername("user");
        } catch (UsernameNotFoundException ex){
        	List<Role> authorities = new ArrayList<Role>(1);
            authorities.add(new Role(Roles.ROLE_USER));
            SproutUser userDetails = new SproutUser("user", "password", "Test",  "User", authorities);
            userRepository.save(userDetails);
        }
        
        try{
        	loadUserByUsername("admin");
        } catch (UsernameNotFoundException ex){
        	List<Role> authorities = new ArrayList<Role>(1);
            authorities.add(new Role(Roles.ROLE_ADMIN));
            SproutUser userDetails = new SproutUser("admin", "password", "Admin",  "User", authorities);
            userRepository.save(userDetails);
        }
	}
}
