package leecode.binarytreeleveltraversal2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leecode.postordertree.TreeNode;

/* Binary Tree Level Order Traversal II
 * Given a binary tree,
 *  return the bottom-up level order traversal of its nodes' values.
 *   (ie, from left to right, level by level from leaf to root).
 *   O(n), O(n)
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	TreeNode deli = new TreeNode(1);
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.offer(root);
    	q.offer(deli);
    	result.add(new ArrayList<Integer>());
    	while (!q.isEmpty()) {
    		TreeNode node = q.poll();
    		if (node == deli) {
    			if (!q.isEmpty()) {
	    			result.add(0, new ArrayList<Integer>());
	    			q.offer(deli);
    			}
    		} else {
    			result.get(0).add(node.val);
    			if (node.left != null) {
    				q.offer(node.left);
    			}
    			if (node.right != null) {
    				q.offer(node.right);
    			}
    		}
    	}
    	return result;
    }
}
