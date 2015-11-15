package savantly.sprout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TreeNodeTag {

	@Id
	@GeneratedValue
	private Long _id;
	@ManyToOne(optional = false)
	private TreeNode treeNode;
	private String text;
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public TreeNode getTreeNode() {
		return treeNode;
	}
	public void setTreeNode(TreeNode treeNode) {
		this.treeNode = treeNode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
