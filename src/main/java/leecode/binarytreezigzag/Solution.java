package leecode.binarytreezigzag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leecode.postordertree.TreeNode;
/* Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * O(n), O(n)
 */
public class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> result  = new ArrayList<>();
			if (root == null) return result;
			boolean reverse = false;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			Queue<TreeNode> tmp = new LinkedList<>();
			result.add(new ArrayList<Integer>());
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (reverse) {
					result.get(result.size()-1).add(0, node.val);
				} else {
					result.get(result.size()-1).add(node.val);
				}
				if (node.left != null) {
					tmp.offer(node.left);
				}
				if (node.right != null) {
					tmp.offer(node.right);
				}
				if (queue.isEmpty()) {
					queue = tmp;
					if (!tmp.isEmpty()) {
						tmp = new LinkedList<>();
						result.add(new ArrayList<Integer>());
					}
					reverse = ! reverse;
				}
			}
			return result;
		}
		
}
