package leecode.bstfrominorderpostorder;

import java.util.HashMap;
import java.util.Map;

import leecode.postordertree.TreeNode;
/* Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * O(n),O(n)
 */
public class Solution {
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
