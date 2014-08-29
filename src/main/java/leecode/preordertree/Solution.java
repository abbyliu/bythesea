package leecode.preordertree;

import java.util.ArrayList;
import java.util.Stack;

import leecode.postordertree.TreeNode;
/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * O(N)
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<>();
      nonRecursive(root, result);
      return result;
    }
    
    @SuppressWarnings("unused")
	private void visit(TreeNode root, ArrayList<Integer> result) {
    	if (root == null) return;
    	result.add(root.val);
    	visit(root.left, result);
    	visit(root.right, result);
    }
    
    private void nonRecursive(TreeNode root, ArrayList<Integer> result) {
    	if (root == null) return;
    	Stack<TreeNode> nodes = new Stack<>();
    	nodes.add(root);
    	
    	while (!nodes.isEmpty()) {
    		TreeNode node = nodes.pop();
    		result.add(node.val);
    		if(node.right != null) {
    			nodes.push(node.right);
    		}
    		if (node.left != null) {
    			nodes.push(node.left);
    		}
    	}
    }
}