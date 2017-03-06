package net.savantly.sprout.domain.tree.repository;

import java.util.List;

public interface TreeRepositoryCustom {

	List<TreeSummary> findAllTreeSummaryByUsername(String username);
}
