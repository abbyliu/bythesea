package leecode.pathsum2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import leecode.postordertree.TreeNode;
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 * O(N)
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;
    	
    	List<Integer> tmp = new ArrayList<>();
    	findAllPaths(root, sum, result, tmp);
    	return result;
    }
    
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
    	if (root == null) return Collections.emptyList();
    	List<Integer> tmp = new ArrayList<>();
    	List<List<Integer>> result = new ArrayList<>();
    	findAll(root, tmp, sum, result);
    	return result;
    }

    private void findAll(TreeNode root, List<Integer> tmp, int sum,
			List<List<Integer>> result) {
		if (root.left == null && root.right == null && root.val == sum) {
			List<Integer> ret = new ArrayList<>(tmp);
			ret.add(root.val);
			result.add(ret);
			return;
		}
		if (root.left != null) {
			tmp.add(root.val);
			findAll(root.left, tmp, sum - root.val, result);
			tmp.remove(tmp.size()-1);
		}
		if (root.right != null) {
			tmp.add(root.val);
			findAll(root.right, tmp, sum - root.val, result);
			tmp.remove(tmp.size()-1);
		}
	}

	@SuppressWarnings("unused")
	private void findAllPathsNonRecursive(TreeNode root, int sum, List<List<Integer>> result) {
    	Stack<TreeNode> nodes = new Stack<>();
    	Stack<Integer> expected = new Stack<>();
    	Stack<List<Integer>> paths = new Stack<>();
    	nodes.add(root);
    	expected.add(sum);
    	paths.add(new ArrayList<Integer>());
    	
    	while (!nodes.isEmpty()) {
    		TreeNode node = nodes.pop();
    		int expectedV = expected.pop();
    		List<Integer> path = paths.pop();
    		if (node.left == null && node.right == null && expectedV == node.val) {
    			path.add(node.val);
    			result.add(path);
    		}
    		if (node.left != null) {
    			nodes.push(node.left);
    			expected.push(expectedV - node.val);
    			List<Integer> copy = new ArrayList<>(path);
    			copy.add(node.val);
    			paths.push(copy);
    		}
    		if (node.right != null) {
    			nodes.push(node.right);
    			expected.push(expectedV - node.val);
    			List<Integer> copy = new ArrayList<>(path);
    			copy.add(node.val);
    			paths.push(copy);
    		}
    	}
    }
    
	private void findAllPaths(TreeNode root, int sum,
			List<List<Integer>> result, List<Integer> tmp) {
		if (root.left == null && root.right == null && root.val == sum) {
			tmp.add(root.val);
			result.add(tmp);
			return;
		}
		if (root.left != null) {
			List<Integer> copy = new ArrayList<>(tmp);
			copy.add(root.val);
			findAllPaths(root.left, sum - root.val, result, copy);
		}
		if (root.right != null) {
			List<Integer> copy = new ArrayList<>(tmp);
			copy.add(root.val);
			findAllPaths(root.right, sum - root.val, result, copy);
		}
	}
}
