package net.savantly.sprout.domain.tree.repository;

import org.springframework.beans.factory.annotation.Value;

import net.savantly.sprout.domain.organization.Organization;

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
