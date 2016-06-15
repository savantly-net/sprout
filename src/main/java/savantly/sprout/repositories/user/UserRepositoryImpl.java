package savantly.sprout.repositories.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.security.Role;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@Autowired
    private MongoTemplate mongoTemplate;
	@Autowired(required=true)
	PasswordEncoder encoder;

	@Override
	public SproutUser insert(SproutUser sproutUser) {
		if(sproutUser.getAuthorities().isEmpty()){
			Set<Role> authorities = new HashSet<Role>(1);
			authorities.add(new Role("ROLE_USER"));
	        sproutUser.setAuthorities(authorities);
		}
        sproutUser.setPassword(encoder.encode(sproutUser.getPassword()));
        sproutUser.setAccountNonExpired(true);
        sproutUser.setAccountNonLocked(true);
        sproutUser.setCredentialsNonExpired(true);
        sproutUser.setEnabled(true);
		mongoTemplate.insert(sproutUser);
		return sproutUser;
	}

	@Override
	public SproutUser insert(String username, String clearTextPassword, String firstName, String lastName) {
		return insert(username, clearTextPassword, firstName, lastName, Collections.<Role> emptySet());
	}

	@Override
	public SproutUser insert(String username, String clearTextPassword, String firstName, String lastName, Set<Role> authorities) {
		SproutUser user = new SproutUser(username, clearTextPassword, firstName, lastName, authorities);
		return insert(user);
	}
}
