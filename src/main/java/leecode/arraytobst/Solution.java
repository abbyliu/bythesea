 package leecode.arraytobst;

import leecode.postordertree.TreeNode;

/* Convert Sorted Array to Binary Search Tree */

//Given an array where elements are sorted in ascending order, 
// convert it to a height balanced BST.

// O(n)
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
    	if (num == null || num.length == 0) return null;
    	int length = num.length;
    	return tobst(num, 0, length-1);
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
