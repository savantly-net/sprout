package savantly.sprout.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class TreeBranch {
	
	@Id
	private String _id;
	private String displayText;
	private TreeNode treeNode;
	
	// These fields will be used in the future to swing to other trees
	private String treeId;
	private String treeNodeId;
	
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
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getTreeNodeId() {
		return treeNodeId;
	}
	public void setTreeNodeId(String treeNodeId) {
		this.treeNodeId = treeNodeId;
	}
	public TreeNode getTreeNode() {
		return treeNode;
	}
	public void setTreeNode(TreeNode treeNode) {
		this.treeNode = treeNode;
	}
}
