package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.activity.Activity;
import savantly.sprout.domain.activity.QActivity;
import savantly.sprout.domain.activity.repository.ActivityRepository;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/activity")
public class ActivityController extends ResourceController<Activity, String, ActivityRepository>{

	@Autowired
	public ActivityController(ActivityRepository entityRepository) {
		super(entityRepository);
	}
	
	@RequestMapping("/tree/{treeId}")
	public Page<Activity> getActivityByTree(@PathVariable String treeId, Pageable pageable){
		QActivity activity = QActivity.activity;
		Page<Activity> queryResult = this.getEntityRepository().findAll(activity.treeId.eq(treeId), pageable);
		return queryResult;
	}
	
	@RequestMapping("/user/{userId}")
	public Page<Activity> getActivityByUserId(@PathVariable String userId, Pageable pageable){
		QActivity activity = QActivity.activity;
		Page<Activity> queryResult = this.getEntityRepository().findAll(activity.createdBy.eq(userId), pageable);
		return queryResult;
	}
}
