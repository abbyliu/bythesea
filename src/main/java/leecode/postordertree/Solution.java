package leecode.postordertree;

import java.util.ArrayList;
import java.util.Stack;
/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * O(n)
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        visitNonRecursiveRevise(root, result);
        return result;
    }
    
    @SuppressWarnings("unused")
	private void visit(TreeNode root, ArrayList<Integer> result) {
    	if (root == null) return;
    	visit(root.left, result);
    	visit(root.right, result);
    	result.add(root.val);
    }
    
    private void visitNonRecursiveRevise(TreeNode root, ArrayList<Integer> result) {
    	if (root == null) return;
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		TreeNode start = root;
		while (start!= null) {
			nodes.push(start);
			start = start.left;
		}
		while (!nodes.isEmpty()) {
			TreeNode n = nodes.peek();
			if (n.right!= null) {
				n = n.right;
				while (n!= null) {
					nodes.push(n);
					n = n.left;
				}
			} else {
				do {
					n = nodes.pop();
					result.add(n.val);
				} while (!nodes.isEmpty() && n == nodes.peek().right);
			}
		}
    }
    
    @SuppressWarnings("unused")
	private void visitNonRecursive(TreeNode root, ArrayList<Integer> result) {
    	if (root == null) return;
    	Stack<TreeNode> nodes = new Stack<>();
    	nodes.add(root);
    	while (!nodes.isEmpty()) {
    		TreeNode node = nodes.peek();
    		if (node.left != null) {
	    		while (node.left != null) {
	    			node = node.left;
	    			nodes.add(node);
	    		}
    		} else if (node.right != null) {
    			node = node.right;
    			nodes.add(node);
    		} else {
    			node = nodes.pop();
    			result.add(node.val);
    			if (!nodes.isEmpty()) {
	    			TreeNode parent = nodes.peek();
	    			if (parent.left == node && parent.right != null) {
	    				node = parent.right;
	    				nodes.add(node);
	    			} else {
	    				while (!nodes.isEmpty() && (parent.right == node || parent.right == null) ) {
	    					node = nodes.pop();
	    					result.add(node.val);
	    					if (!nodes.isEmpty())
	    						parent = nodes.peek();
	    				}
	    				if (!nodes.isEmpty() && parent.right != null) {
	    					nodes.add(parent.right);
	    				}
	    			}
    			}
    		}
    		
    	}
    	
    }
}