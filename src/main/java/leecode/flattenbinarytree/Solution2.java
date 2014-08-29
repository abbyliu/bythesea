package leecode.flattenbinarytree;

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
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode n = root.left;
                while (n.right != null) {
                    n = n.right;
                }
                n.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }        
        
        
        
}