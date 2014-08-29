package leecode.mindepthbinarytree;

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new LinkedList<>();
        Deque<TreeNode> tmp = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left == null && n.right == null) return depth;
            if (n.left != null) {
                tmp.offer(n.left);
            }
            if (n.right!= null) {
                tmp.offer(n.right);
            }
            if (q.isEmpty()) {
                q = tmp;
                tmp = new LinkedList<>();
                depth++;
            }
        }
        return depth;
   }
}