package leecode.binarytreemaxsum;

import java.util.ArrayList;
import java.util.List;

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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        List<Integer> v = new ArrayList<>();
        v.add(Integer.MIN_VALUE);
        findMax(root, v);
        return v.get(0);
    }
    private int findMax(TreeNode node, List<Integer> v) {
        if (node == null)  return 0;
        int left = findMax(node.left, v);
        if (left < 0) {
            left = 0;
        }
        int right = findMax(node.right, v);
        if (right < 0) {
            right = 0;
        }
        int value = node.val + left + right;
        if (value > v.get(0)) {
            v.set(0, value);
        }
        return Math.max(left, right) + node.val;
    }
    
 
}