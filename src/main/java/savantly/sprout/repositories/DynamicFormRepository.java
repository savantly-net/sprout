package savantly.sprout.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import savantly.sprout.domain.DynamicForm;

public interface DynamicFormRepository extends MongoRepository<DynamicForm, String>{

}
