package leecode.arraytobst;

import leecode.postordertree.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length==0) return null;
        return buildTree(num, 0, num.length-1);
    }
    
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildTree(num, start, mid-1);
        root.right = buildTree(num, mid+1, end);
        return root;
    }
}
