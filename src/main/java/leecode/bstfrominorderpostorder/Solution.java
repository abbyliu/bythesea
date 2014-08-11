package leecode.bstfrominorderpostorder;

import java.util.HashMap;
import java.util.Map;

import leecode.postordertree.TreeNode;
/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * O(n),O(n)
 */
public class Solution {
	public TreeNode buildTree2(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0)  return null;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTree3(map, inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}
	
	private TreeNode buildTree3(Map<Integer, Integer> map, int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
		if (inorderStart > inorderEnd || postorderStart > postorderEnd) return null;
		TreeNode root = new TreeNode(postorder[postorderEnd]);
		int idx = map.get(root.val);
		int length = idx - inorderStart;
		root.left = buildTree3(map, inorder, inorderStart, idx-1, postorder, postorderStart, postorderStart + length-1);
		root.right = buildTree3(map, inorder, idx+1, inorderEnd, postorder, postorderStart + length, postorderEnd-1);
		return root;
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1) return null;
        if (inorder.length != postorder.length ) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
        	inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, inorderMap);
        return root;
    }

	private TreeNode buildTree(int[] inorder, int[] postorder, int i, int j,
			int k, int l, Map<Integer, Integer> map) {
		if (i > j) return null;
		if (k > l) return null;
		TreeNode middle = new TreeNode(postorder[l]);
		int idx = map.get(middle.val);
		int length = idx - i;
		middle.left = buildTree(inorder, postorder, i, idx -1, k, k+length-1, map);
		middle.right = buildTree(inorder, postorder, idx+1, j, k + length, l-1, map);
		return middle;
	}
}
