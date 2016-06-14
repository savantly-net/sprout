package savantly.sprout.repositories.tree;

import org.springframework.beans.factory.annotation.Value;

import savantly.sprout.domain.Organization;

public interface TreeSummary {
	String getId();
	String getName();
	String getDescription();
	String getCoverImageUrl();
	boolean getIsPublic();
	Organization getOrganization();
	@Value("#{target.pages.size()}")
	int getPageCount();
}
