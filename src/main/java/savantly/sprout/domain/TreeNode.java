package savantly.sprout.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TreeNode {
	
	@Id
	private UUID _id;
	private Boolean isStartPage;
	private String title;
	private String body;
	private String imageUrl;
	private List<String> tags;
	private List<TreeBranch> choices;
	
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
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<TreeBranch> getChoices() {
		return choices;
	}
	public void setChoices(List<TreeBranch> choices) {
		this.choices = choices;
	}

}
