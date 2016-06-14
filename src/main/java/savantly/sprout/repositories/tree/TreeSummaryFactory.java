package savantly.sprout.repositories.tree;

import static savantly.sprout.domain.QTree.tree;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.MappingProjection;

public class TreeSummaryFactory extends MappingProjection<TreeSummary> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5060375998748219244L;

	public TreeSummaryFactory() {
		super(TreeSummary.class, 
				tree.id, 
				tree.name, 
				tree.description, 
				tree.coverImageUrl, 
				tree.isPublic, 
				tree.organization, 
				tree.pages.size());
	}

	@Override
	protected TreeSummary map(Tuple row) {
		return new TreeSummaryImpl(
				row.get(tree.id), 
				row.get(tree.name), 
				row.get(tree.description), 
				row.get(tree.coverImageUrl), 
				row.get(tree.isPublic), 
				row.get(tree.organization), 
				row.get(tree.pages.size()));
	}

}
