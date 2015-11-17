package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Tree {

	@Id
	private String _id;
	@Version
	private Long version;
	@CreatedDate
	private DateTime created = new DateTime();
	@CreatedBy
	@DBRef
	private SproutUserDetails user = new SproutUserDetails();
	private String name;
	private String description;
	private String coverImageUrl;
	private boolean isPublic = true;
	private Set<TreeNode> pages = new HashSet<>();

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
}
