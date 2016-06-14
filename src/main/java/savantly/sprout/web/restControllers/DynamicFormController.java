package savantly.sprout.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savantly.sprout.domain.DynamicForm;
import savantly.sprout.domain.SproutUser;
import savantly.sprout.repositories.dynamicForm.DynamicFormRepository;
import savantly.sprout.web.angular.ResourceController;

@RestController
@RequestMapping("/rest/forms")
public class DynamicFormController extends ResourceController<DynamicForm, String, DynamicFormRepository>{

	private MongoRepository<DynamicForm, String> entityRepository;

	@Autowired
	public DynamicFormController(DynamicFormRepository entityRepository) {
		super(entityRepository);
		this.entityRepository = entityRepository;
	}
	
	@Override
	@PreAuthorize("isAuthenticated()")
	protected boolean canCreate(DynamicForm model, SproutUser currentUser) {
		return super.canCreate(model, currentUser);
	}
	
	@Override
	@PreAuthorize("isAuthenticated()")
	protected boolean canDelete(String id, SproutUser currentUser) {
		DynamicForm dynamicForm = this.entityRepository.findOne(id);
		if(dynamicForm == null) return false;
		else return dynamicForm.getCreatedBy().equals(currentUser);
	}
	
	@Override
	@PreAuthorize("isAuthenticated() and #model.createdBy == principal.username")
	protected boolean canUpdate(DynamicForm model, SproutUser currentUser) {
		return super.canUpdate(model, currentUser);
	}

}
