package leecode.pathsum;

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Deque<TreeNode> q = new LinkedList<>();
        int v = 0;
        TreeNode n = root;
        while (n!= null) {
          v += n.val;
          q.push(n);
          n = n.left;
        }
        while (!q.isEmpty()) {
            TreeNode t = q.peek();
            if (t.right!= null) {
                t = t.right;
                while (t!= null) {
                    v += t.val;
                    q.push(t);
                    t = t.left;
                }
            } else {
                if (t.left == null && t.right == null && v == sum) return true;
                do {
                    t = q.pop();
                    v -=t.val;
                } while (!q.isEmpty() && q.peek().right == t) ;
            }
        }
        return false;
    }
}