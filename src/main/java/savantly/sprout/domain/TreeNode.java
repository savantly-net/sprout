package savantly.sprout.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class TreeNode {
	
	@Id
	private String _id;
	private boolean isStartPage;
	private String title;
	private String body;
	private String imageUrl;
	private Set<TreeNodeTag> tags = new HashSet<>();
	private Set<TreeBranch> choices = new HashSet<>();
	@DBRef
	private DynamicForm form;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public boolean getIsStartPage() {
		return isStartPage;
	}
	public void setIsStartPage(boolean isStartPage) {
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
	public DynamicForm getForm() {
		return form;
	}
	public void setForm(DynamicForm form) {
		this.form = form;
	}
}
