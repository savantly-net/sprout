package savantly.sprout.repositories.tree;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import savantly.sprout.domain.Tree;
import savantly.sprout.repositories.ExtendedMongoRepository;

public interface TreeRepository extends ExtendedMongoRepository<Tree, String>, TreeRepositoryCustom {

	//TreeSummary findOneTreeSummaryById(String id);
	@Query("{'createdBy.username': 'admin'}")
	List<TreeSummary> findTreeSummaryListByUsername(String username);
}
