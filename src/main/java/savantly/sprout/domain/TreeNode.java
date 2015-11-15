package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TreeNode {
	
	@Id
	private UUID _id;
	private Boolean isStartPage;
	private String title;
	private String body;
	private String imageUrl;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "treeNode")
	private Set<TreeNodeTag> tags = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "treeNode")
	private Set<TreeBranch> choices = new HashSet<>();
	@ManyToOne(optional = false)
	private Tree tree;
	
	public UUID get_id() {
		return _id;
	}
	public void set_id(UUID _id) {
		this._id = _id;
	}
	public Boolean getIsStartPage() {
		return isStartPage;
	}
	public void setIsStartPage(Boolean isStartPage) {
		this.isStartPage = isStartPage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Set<TreeNodeTag> getTags() {
		return tags;
	}

	public Set<TreeBranch> getChoices() {
		return choices;
	}
}
