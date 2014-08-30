package leecode.validatebst;

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValidBST(root, min, max);
    }
    
    private boolean isValidBST(TreeNode t, int min, int max) {
        if (t == null) return true;
        if ( t.val <= min) return false;
        if ( t.val >= max) return false;
        return isValidBST(t.left, min, t.val) &&
                 isValidBST(t.right, t.val, max);
    }
}