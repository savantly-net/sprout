package savantly.sprout.domain.tree.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import savantly.sprout.domain.tree.Tree;
import savantly.sprout.mongo.repository.ExtendedMongoRepository;

public interface TreeRepository extends ExtendedMongoRepository<Tree, String>, TreeRepositoryCustom {

	//TreeSummary findOneTreeSummaryById(String id);
	@Query("{'createdBy.username': '?0'}")
	List<TreeSummary> findTreeSummaryListByUsername(String username);
	
}
