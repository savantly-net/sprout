package savantly.sprout.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.repositories.UserRepository;

@Component
public class SproutUserDetailsService implements UserDetailsService, InitializingBean {

	@Autowired
	UserRepository userRepository;
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
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
        	loadUserByUsername("user");
        } catch (UsernameNotFoundException ex){
        	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
            authorities.add(new SimpleGrantedAuthority("USER"));
            SproutUser userDetails = new SproutUser("user", encoder.encode("password"), authorities);
            userRepository.save(userDetails);
        }
        
        try{
        	loadUserByUsername("admin");
        } catch (UsernameNotFoundException ex){
        	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            SproutUser userDetails = new SproutUser("admin", encoder.encode("password"), authorities);
            userRepository.save(userDetails);
        }
	}
}
