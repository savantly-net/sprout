package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonProperty;

import savantly.sprout.web.security.AbstractAuditableDomainObject;

public class Tree extends AbstractAuditableDomainObject<String>{

	private static final long serialVersionUID = -7600786993360904898L;
	
	@Id
	@JsonProperty("_id")
	private String id;
	private String name;
	private String description;
	private String coverImageUrl;
	private boolean isPublic = true;
	private Set<TreeNode> pages = new HashSet<>();
	@Version
	private Long version;

	public String getId() {
		return id;
	}

	public void setId(String _id) {
		this.id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Set<TreeNode> getPages() {
		return pages;
	}

	public void setPages(Set<TreeNode> pages) {
		this.pages = pages;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
