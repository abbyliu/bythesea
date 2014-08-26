package leecode.preordertree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            ret.add(n.val);
            if (n.right!= null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        return ret;
    }
}