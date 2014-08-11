package leecode.balancedbinarytree;

import leecode.postordertree.TreeNode;


/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined 
as a binary tree in which the depth of the two subtrees of 
every node never differ by more than 1.

  O(n) time complexity and of O(logn) space complexity.
*/


public class Solution {
		private boolean balanced = true;
		
	    public boolean isBalanced3(TreeNode root) {
	    	maxDepth(root);
	    	return balanced;
	    }
	    
	    private int maxDepth(TreeNode root) {
	    	if (root == null || !balanced) return 0;
	    	int left = maxDepth(root.left) +1;
	    	int right = maxDepth(root.right) +1;
	    	if (Math.abs(left -right) > 1) balanced = false;
	    	return Math.max(left, right);
		}

		public boolean isBalanced(TreeNode root) {
	    	if (root == null) return true;
	    	int depthl = getDepth(root.left);
	    	int depthr = getDepth(root.right);
	    	if (Math.abs(depthl-depthr) > 1) return false;
	    	return isBalanced(root.left) && isBalanced(root.right);
	    }

	    public boolean isBalanced2(TreeNode root) {
	    	if (root == null) return true;
	    	int leftDepth = getDepth2(root.left);
	    	int rightDepth = getDepth2(root.right);
	    	if (Math.abs(leftDepth-rightDepth) > 1) return false;
	    	return isBalanced2(root.left) && isBalanced2(root.right);
	    }
	    private int getDepth2(TreeNode root) {
	    	if (root == null) return 0;
	    	int left = getDepth2(root.left);
	    	int right = getDepth2(root.right);
	    	return Math.max(left, right) +1;
	    }
		private int getDepth(TreeNode left) {
			if (left == null) return 0;
			int leftv = getDepth(left.left);
			int rightv = getDepth(left.right);
			return 1 + Math.max(leftv, rightv);
		}
}
