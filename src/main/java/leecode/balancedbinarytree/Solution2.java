package leecode.balancedbinarytree;

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
    private boolean b = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return b;
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        if (!b) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right)>1) {
            b = false;
            return 0;
        }
        return 1 + Math.max(left, right);
    }
    

}
