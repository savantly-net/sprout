package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tree {

	@Id
	@JsonProperty("_id")
	private String id;
	@Version
	private Long version;
	@CreatedDate
	private DateTime created;
	@CreatedBy
	@DBRef
	private SproutUserDetails user = new SproutUserDetails();
	private String name;
	private String description;
	private String coverImageUrl;
	private boolean isPublic = true;
	private Set<TreeNode> pages = new HashSet<>();

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

	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
	}

	public SproutUserDetails getUser() {
		return user;
	}

	public void setUser(SproutUserDetails user) {
		this.user = user;
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
