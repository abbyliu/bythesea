package leecode.binarytreemaxsum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leecode.postordertree.TreeNode;

/*
 *  Given a binary tree, find the maximum path sum.
    The path may start and end at any node in the tree. 
    O(n), O(log(n))
 */
public class Solution {
	private int max = Integer.MIN_VALUE;
	
	public int maxPathSum2(TreeNode root) {
		if (root == null) return 0;
		maxSum(root);
		return max;
	}
    private int maxSum(TreeNode node) {
    	if (node == null) return 0;
		int left = maxSum(node.left);
		if (left < 0) {
			left = 0;
		}
		int right = maxSum(node.right);
		if (right < 0) {
			right = 0;
		}
		
		max = Math.max(max, node.val + left + right);
		
		return node.val + Math.max(left, right);
	}
	public int maxPathSum(TreeNode root) {
    	if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        max(root, map);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	TreeNode t = q.poll();
        	int r = t.val;
        	if (t.left != null) {
        		int left = max(t.left, map);
        		if (left < 0) {
        			left = 0;
        		}
        		r += left;
        		q.offer(t.left);
        	}
        	if (t.right != null) {
        		int right = max(t.right, map);
        		if (right < 0) {
        			right = 0;
        		}
        		r += right;
        		q.offer(t.right);
        	}
        	max = Math.max(max, r);
        }
        return max;
    }
    
    private int max(TreeNode root, Map<TreeNode, Integer> map) {
    	Integer result = map.get(root);
    	if (result != null) {
    		return result;
    	}
    	int left = 0;
    	if (root.left!= null) {
    		left = max(root.left, map);
    		if (left < 0) {
    			left = 0;
    		}
    	}
    	int right = 0;
    	if (root.right != null) {
    		right = max(root.right, map);
    		if (right < 0) {
    			right = 0;
    		}
    	}
    	int r = Math.max(left, right) + root.val;
    	map.put(root, r);
    	return r;
    }
}