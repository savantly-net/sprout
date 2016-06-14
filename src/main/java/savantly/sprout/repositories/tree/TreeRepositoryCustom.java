package savantly.sprout.repositories.tree;

import java.util.List;

public interface TreeRepositoryCustom {

	List<TreeSummary> findAllTreeSummaryByUsername(String username);
}
