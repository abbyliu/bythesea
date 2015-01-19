package leecode.balancedbinarytree;

import leecode.postordertree.TreeNode;


/* Balanced Binary Tree

 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined 
as a binary tree in which the depth of the two subtrees of 
every node never differ by more than 1.

  O(n) time complexity and of O(logn) space complexity.
*/


public class Solution {
		private boolean balanced = true;
		
	    public boolean isBalanced(TreeNode root) {
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

}
