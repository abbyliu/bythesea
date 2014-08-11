 package leecode.arraytobst;

import leecode.postordertree.TreeNode;

//Given an array where elements are sorted in ascending order, 
// convert it to a height balanced BST.

// O(n)
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
    	if (num == null || num.length == 0) return null;
    	int length = num.length;
    	return tobst(num, 0, length-1);
    }

    public TreeNode sortedArrayToBST2(int[] num) {
    	if (num == null || num.length == 0) return null;
    	int length = num.length;
    	return tobst2(num, 0, length-1);
    }
    public TreeNode tobst2(int[] num, int start, int end) {
    	if (start > end) return null;
    	int mid = start  + (end - start)/2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = tobst2(num, start, mid -1);
    	root.right = tobst2(num, mid+1, end);
    	return root;
    	
    }
	private TreeNode tobst(int[] num, int i, int j) {
		if ( i > j) return null;
		int mid = i + (j-i)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = tobst(num, i, mid-1);
		root.right = tobst(num, mid+1, j);
		return root;
	}
}
