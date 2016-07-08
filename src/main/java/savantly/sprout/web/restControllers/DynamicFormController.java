package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.dynamicForm.DynamicForm;
import savantly.sprout.domain.dynamicForm.repository.DynamicFormRepository;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/forms")
public class DynamicFormController extends ResourceController<DynamicForm, String, DynamicFormRepository>{

	@Autowired
	public DynamicFormController(DynamicFormRepository entityRepository) {
		super(entityRepository);
	}
}
