package savantly.sprout.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import savantly.sprout.domain.Tree;

public interface TreeRepository extends MongoRepository<Tree, String>{

}
