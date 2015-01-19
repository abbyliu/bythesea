package leecode.pathsum;

import java.util.Stack;

import leecode.postordertree.TreeNode;
/*  Path Sum
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
O(n), O(lgn) 
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) return false;
    	if (root.val == sum && root.left == null && root.right == null) return true;
    	boolean leftMatch = hasPathSum(root.left, sum - root.val);
    	if (leftMatch) return true;
    	boolean rightMatch = hasPathSum(root.right, sum - root.val);
    	return rightMatch;
    }
    
    public boolean hasPathSumNonRecursive(TreeNode root, int sum) {
    	if (root == null) return false;
    	Stack<TreeNode> nodes = new Stack<>();
    	nodes.push(root);
    	Stack<Integer> expected = new Stack<>();
    	expected.push(sum);
    	while ( !nodes.isEmpty()) {
    		int expectedV = expected.pop();
    		TreeNode node = nodes.pop();
    		if (node.left == null && node.right == null && expectedV == node.val) {
    			return true;
    		}
    		if (node.left != null) {
    			nodes.push(node.left);expected.push(expectedV - node.val);
    		}
    		if (node.right != null) {
    			nodes.push(node.right);expected.push(expectedV - node.val);
    		}
    	}
    	return false;
    } 
}