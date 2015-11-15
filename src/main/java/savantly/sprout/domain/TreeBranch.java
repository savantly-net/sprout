package savantly.sprout.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TreeBranch {
	
	@Id
	private UUID _id;
	private String displayText;
	private TreeNode treeNode;
	
	public UUID get_id() {
		return _id;
	}
	public void set_id(UUID _id) {
		this._id = _id;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public TreeNode getTreeNode() {
		return treeNode;
	}
	public void setTreeNode(TreeNode treeNode) {
		this.treeNode = treeNode;
	}
}
