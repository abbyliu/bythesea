package leecode.flattenbinarytree;

import leecode.postordertree.TreeNode;
/*
 * Given a binary tree, flatten it to a linked list in-place.
 * O(n), O(logn)
 */

public class Solution {
	
	public TreeNode flattern2(TreeNode node) {
		if (node == null) return node;
		if (node.left!= null) {
			TreeNode start = node.left;
			while (start.right!= null) {
				start = start.right;
			}
			start.right = node.right;
			node.right = node.left;
			node.left = null;
		}
		flattern2(node.right);
		return node;
	}
	
    public void flatten(TreeNode root) {
    	if (root == null) return;
    	TreeNode node = root;
    	while (node != null) {
    		if (node.left != null) {
    			TreeNode rightMost = node.left;
    			while (rightMost.right != null) {
    				rightMost = rightMost.right;
    			}
    			rightMost.right = node.right;
    			node.right = node.left;
    			node.left = null;
    		}
    		node = node.right;
    	}
    }
}