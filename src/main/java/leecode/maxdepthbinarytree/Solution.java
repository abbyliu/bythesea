package leecode.maxdepthbinarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import leecode.postordertree.TreeNode;

/*Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public int maxDepth3(TreeNode root) {
    	if (root == null) return 0;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.offer(root);
    	int depth = 1;
    	Queue<TreeNode> tmp = new LinkedList<>();
    	while (!q.isEmpty()) {
    		TreeNode node = q.poll();
    		if (node.left!= null) {
    			tmp.offer(node.left);
    		}
    		if (node.right != null) {
    			tmp.offer(node.right);
    		}
    		if(q.isEmpty()) {
    			q = tmp;
    			if (!q.isEmpty()) {
    				depth++;
    			}
    			tmp = new LinkedList<>();
    		}
    	}
    	return depth;
    }
    public int maxDepth2(TreeNode root) {
    	if (root == null) return 0;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode start = root;
    	int max = 0;
    	while (start != null) {
    		stack.push(start);
    		start = start.left;
    	}
    	while (!stack.isEmpty()) {
    		max = Math.max(max, stack.size());
    		TreeNode node = stack.peek();
    		TreeNode right = node.right;
    		if (right != null) {
	    		while (right != null) {
	    			stack.push(right);
	    			right = right.left;
	    		}
    		} else {
    			do {
    				node = stack.pop();
    			} while (!stack.isEmpty() && node == stack.peek().right);
    		}
    	}
    	return max;
    }
}