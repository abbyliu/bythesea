package leecode.validatebst;

import leecode.postordertree.TreeNode;
/*  Validate Binary Search Tree
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) return true;
		if (root.val <= min || root.val >= max) return false;
		return isValidBST(root.left, min, root.val)
				 && isValidBST(root.right, root.val, max);
	}
}