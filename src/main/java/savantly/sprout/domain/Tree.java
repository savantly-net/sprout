package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Tree {

	@Id
	private UUID _id;
	private String name;
	private String description;
	private String coverImageUrl;
	private Boolean isPublic;
	private DateTime created;
	private UserDetails user;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tree")
	private Set<TreeNode> pages = new HashSet<>();
	
	public UUID get_id() {
		return _id;
	}
	public void set_id(UUID _id) {
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
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public DateTime getCreated() {
		return created;
	}
	public void setCreated(DateTime created) {
		this.created = created;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Set<TreeNode> getPages() {
		return pages;
	}
}
