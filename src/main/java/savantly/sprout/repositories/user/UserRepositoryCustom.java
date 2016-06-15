package savantly.sprout.repositories.user;

import java.util.Set;

import savantly.sprout.domain.SproutUser;
import savantly.sprout.security.Role;

public interface UserRepositoryCustom {
	SproutUser insert(SproutUser sproutUser);
	SproutUser insert(String username, String clearTextPassword, String firstName, String lastName);
	SproutUser insert(String username, String clearTextPassword, String firstName, String lastName, Set<Role> authorities);
}
