package leecode.binarytreefrompreinorder;

import java.util.HashMap;
import java.util.Map;

import leecode.postordertree.TreeNode;
/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
   Note:
   You may assume that duplicates do not exist in the tree. 
   
   O(n),O(n)
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length < 1 || preorder.length < 1) return null;
        if (inorder.length != preorder.length ) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
        	inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1, inorderMap);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
    	if (preorder == null || inorder == null) return null;
    	if (preorder.length != inorder.length) return null;
    	Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    	for (int i = 0; i < inorder.length; i++ ) {
    		inorderIndexMap.put(inorder[i], i);
    	}
    	return buildTree2(inorderIndexMap, inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
    
    private TreeNode buildTree2(Map<Integer, Integer> map, int[] inorder, int inorderStart, int inorderEnd, int[] preorder, int preorderStart, int preorderEnd) {
    	if (inorderStart > inorderEnd) return null;
    	if (preorderStart > preorderEnd) return null;
    	int idx = map.get(preorder[preorderStart]);
    	int length = idx - inorderStart;
    	TreeNode root = new TreeNode(preorder[preorderStart]);
    	root.left = buildTree2(map, inorder, inorderStart, idx-1, preorder, preorderStart + 1, preorderStart + length);
    	root.right = buildTree2(map, inorder, idx+1, inorderEnd, preorder, preorderStart + length +1, preorderEnd);
    	return root;
    }
	private TreeNode buildTree(int[] inorder, int[] preorder, int i, int j,
			int k, int l, Map<Integer, Integer> map) {
		if (i > j) return null;
		if (k > l) return null;
		TreeNode middle = new TreeNode(preorder[k]);
		int idx = map.get(middle.val);
		int length = idx - i;
		middle.left = buildTree(inorder, preorder, i, idx -1, k+1, k+length, map);
		middle.right = buildTree(inorder, preorder, idx+1, j, k + length+1, l, map);
		return middle;
	}
}