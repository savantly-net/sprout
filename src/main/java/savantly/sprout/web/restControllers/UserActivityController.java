package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.UserActivity;
import savantly.sprout.repositories.UserActivityRepository;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/activity")
public class UserActivityController extends ResourceController<UserActivity, String>{

	@Autowired
	public UserActivityController(UserActivityRepository entityRepository) {
		super(entityRepository);
	}
}
