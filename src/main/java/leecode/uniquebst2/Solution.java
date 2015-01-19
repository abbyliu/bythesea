package leecode.uniquebst2;

import java.util.ArrayList;
import java.util.List;

import leecode.postordertree.TreeNode;
/* Unique Binary Search Trees II
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
O(exp)
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	return dfs(1, n);
    }

	private List<TreeNode> dfs(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = dfs(start, i-1);
			List<TreeNode> rights = dfs(i+1, end);
			for (TreeNode left: lefts) {
				for (TreeNode right: rights) {
					TreeNode treeNode = new TreeNode(i);
					treeNode.left = left;
					treeNode.right = right;
					result.add(treeNode);
				}
			}
		}
		return result;
	}
}