package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.DynamicForm;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/forms")
public class DynamicFormController extends ResourceController<DynamicForm, String>{

	@Autowired
	public DynamicFormController(MongoRepository<DynamicForm, String> entityRepository) {
		super(entityRepository);
	}

}
