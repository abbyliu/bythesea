package leecode.mindepthbinarytree;

import leecode.postordertree.TreeNode;
/* Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
O(logN)
 */
public class Solution {
    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	int left = minDepth(root.left);
    	int right  = minDepth(root.right);
    	if (left == 0) {
    		return 1 + right;
    	} 
    	if (right == 0) {
    		return 1 + left;
    	}
    	return 1 + Math.min(left,  right);
    }
}