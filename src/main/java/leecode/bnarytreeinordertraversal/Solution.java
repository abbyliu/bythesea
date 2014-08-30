package leecode.bnarytreeinordertraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode n = root;
        while (n!= null) {
            q.push(n); n = n.left;
        }
        while (!q.isEmpty()) {
            n = q.peek();
            result.add(n.val);
            if (n.right != null) {
                n = n.right;
                while(n!= null) {
                    q.push(n);n=n.left;
                }
            } else {
                do {
                    n = q.pop();
                } while (!q.isEmpty()&& q.peek().right == n);
            }
        }
        return result;
      }
}