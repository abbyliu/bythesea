package leecode.recoverbst;

import java.util.Stack;

import leecode.postordertree.TreeNode;
/*
 *  Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
O(N)
 */
public class Solution {
	
	public void recoverTree2(TreeNode root) {
		
		if (root == null) return;

		TreeNode r1 = null;
		TreeNode r2 = null;
		TreeNode previous = null;
		while(root !=null) {
			if (previous != null && previous.val > root.val) {
				if (r1 == null) {
					r1 = previous;
				}
				r2 = root;
			}
			if (root.left ==  null) {
				previous = root;
				root = root.right;
			} else {
				TreeNode left = root.left;
				while (left.right != null && left.right != root) {
					left = left.right;
				}
				if (left.right == null) {
					left.right = root;
					root = root.left;
				} else {
					left.right = null;
					previous = root;
					root = root.right;
				}
			}
		}
		if (r1 != null && r2 != null) {
			int tmp = r2.val;
			r2.val = r1.val;
			r1.val = tmp;
		}
	}
    public void recoverTree(TreeNode root) {
    	if (root == null) return;
    	Stack<TreeNode> nodes = new Stack<TreeNode>();
    	TreeNode node1 = null;
    	TreeNode node2 = null;
    	TreeNode start = root;
    	TreeNode previous = null;
    	while (start != null) {
    		nodes.push(start);start = start.left;
    	}
    	while (!nodes.isEmpty()) {
    		TreeNode node = nodes.peek();
    		if (previous != null) {
	    		if (node.val < previous.val) {
	    			if (node1 == null) {
	    				node1 = previous;
	    				node2 = node;
	    			} else {
	    				node2 = node;
	    				break;
	    			}
	    		}
    		}
    		previous = node;
    		if (node.right != null) {
    			TreeNode right = node.right;
    			while (right != null) {
    				nodes.push(right);
    				right = right.left;
    			}
    		} else {
    			do {
    				node = nodes.pop();
    			} while ( ! nodes.isEmpty() && node == nodes.peek().right);
    		}
    	}
   		if (node1 != null && node2!= null) {
			int tmp = node1.val;
			node1.val = node2.val;
			node2.val = tmp;
		} else if (node1 != null) {
			int tmp = root.val;
			root.val = node1.val;
			node1.val = tmp;
		}
    }
    public static void main(String[] args) {
    	TreeNode root=  new TreeNode(2);
    	root.right = new TreeNode(1);
    	Solution s = new Solution();
    	s.recoverTree(root);
    }
}