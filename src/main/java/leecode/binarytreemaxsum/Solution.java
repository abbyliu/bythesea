package leecode.binarytreemaxsum;

import leecode.postordertree.TreeNode;

/*  Binary Tree Maximum Path Sum
 *  Given a binary tree, find the maximum path sum.
    The path may start and end at any node in the tree. 
    O(n), O(log(n))
 */
public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int v = getMaxWithRoot(root);
        return Math.max(max, v);
    }
    
    private int getMaxWithRoot(TreeNode root) {
        int v = root.val;
        
        int left = 0;
        if (root.left != null) {
            left = getMaxWithRoot(root.left);
            if (left < 0) {
                left = 0;
            }
        }
        int right = 0;
        if (root.right != null) {
            right = getMaxWithRoot(root.right);
            if (right < 0) {
                right = 0;
            }
        }
        
        int val = v + left + right;
        
        if (val > max) {
            max = val;
        }
        
        return v + Math.max(left, right);
    }
}