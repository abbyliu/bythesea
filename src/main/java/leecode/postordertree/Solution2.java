package leecode.postordertree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode start = root;
        while (start != null) {
            stack.push(start);
            start =start.left;
        }
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode n = stack.peek();
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
            } else {
                do {
                    n = stack.pop();
                    ret.add(n.val);
                } while (!stack.isEmpty() && stack.peek().right == n);
            }
        }
            return ret;
    }
}