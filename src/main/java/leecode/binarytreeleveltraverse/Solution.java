package leecode.binarytreeleveltraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leecode.postordertree.TreeNode;
/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * O(n), O(n)
 */


public class Solution {
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		result.add(new ArrayList<Integer>());
		Queue<TreeNode> tmp = new LinkedList<>();
		while (! queue.isEmpty()) {
			TreeNode node = queue.poll();
			result.get(result.size()-1).add(node.val);
			if (node.left!= null) {
				tmp.offer(node.left);
			}
			if (node.right != null) {
				tmp.offer(node.right);
			}
			if (queue.isEmpty()) {
				queue = tmp;
				if (!queue.isEmpty()) {
					tmp = new LinkedList<>();
					result.add(new ArrayList<Integer>());
				}
			}
		}
		return result;
	}
	
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        result.add(new ArrayList<Integer>());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<TreeNode> tmp = new LinkedList<>();
        while (!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	result.get(result.size()-1).add(node.val);
        	if (node.left!= null) {
        		tmp.offer(node.left);
        	}
        	if (node.right != null) {
        		tmp.offer(node.right);
        	}
        	if (queue.isEmpty() && !tmp.isEmpty()) {
        		queue.addAll(tmp);
        		tmp.clear();
        		result.add(new ArrayList<Integer>());
        	}
        }
        return result;
    }
}