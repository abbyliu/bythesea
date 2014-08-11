package leecode.validatebst;

import leecode.postordertree.TreeNode;
/*
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	private boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) return true;
		if (root.val <= min || root.val >= max) return false;
		if (root.left != null && root.left.val >= root.val) return false;
		if (root.right != null && root.right.val <= root.val) return false;
		return isValidBST(root.left, min, root.val)
				 && isValidBST(root.right, root.val, max);
	}
}