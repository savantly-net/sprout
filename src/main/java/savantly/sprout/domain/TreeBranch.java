package savantly.sprout.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class TreeBranch {
	
	@Id
	private String _id;
	private String displayText;
	@DBRef
	private TreeNode treeNode;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
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
