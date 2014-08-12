package leecode.mindepthbinarytree;

import java.util.LinkedList;
import java.util.Queue;

import leecode.postordertree.TreeNode;
/*
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
    public int minDepth2(TreeNode root) {
    	if (root == null) return 0;
    	Queue<TreeNode> q =new LinkedList<>();
    	q.offer(root);
    	Queue<TreeNode> tmp = new LinkedList<>();
    	int lvl = 1;
    	while (!q.isEmpty()) {
    		TreeNode node = q.poll();
    		if (node.left==null && node.right == null) {
    			return lvl;
    		}
    		if (node.left!= null) {
    			tmp.offer(node.left);
    		}
    		if (node.right != null) {
    			tmp.offer(node.right);
    		}
    		if (q.isEmpty()) {
    			q = tmp;
    			lvl++;
    			tmp = new LinkedList<>();
    		}
    	}
    	return lvl;
    }
    public int minDepthNonRecursive(TreeNode root) {
    	if (root == null) return 0;
    	Queue<TreeNode> nodes = new LinkedList<>();
    	nodes.offer(root);
    	Queue<Integer> level = new LinkedList<>();
    	level.offer(1);
    	while (!nodes.isEmpty()) {
    		TreeNode node = nodes.poll();
    		int lev = level.poll();
    		if (node.left == null && node.right == null) {
    			return lev;
    		}
    		if (node.left != null) {
    			nodes.offer(node.left);
    			level.offer(lev+1);
    		}
    		if (node.right != null) {
    			nodes.offer(node.right);
    			level.offer(lev+1);
    		}
    	}
    	return Integer.MAX_VALUE;
    }
}