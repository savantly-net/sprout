package savantly.sprout.repositories.tree;

import com.querydsl.core.annotations.QueryProjection;

import savantly.sprout.domain.Organization;

public class TreeSummaryImpl implements TreeSummary {

	private String id;
	private String name;
	private String description;
	private String coverImageUrl;
	private boolean isPublic;
	private Organization organization;
	private int pageCount;

	@QueryProjection
	public TreeSummaryImpl(String id, String name, String description, String coverImageUrl, boolean isPublic,
			Organization organization, int pageCount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.coverImageUrl = coverImageUrl;
		this.isPublic = isPublic;
		this.organization = organization;
		this.pageCount = pageCount;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	@Override
	public boolean getIsPublic() {
		return isPublic;
	}

	@Override
	public Organization getOrganization() {
		return organization;
	}

	@Override
	public int getPageCount() {
		return pageCount;
	}

}
