package leecode.maxdepthbinarytree;

import java.util.Deque;
import java.util.LinkedList;

import leecode.postordertree.TreeNode;


/*Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class Solution2 {
    public int maxDepth(TreeNode root) {
   
        if (root == null) return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode start = root;
        while (start != null) {
            stack.push(start);
            start =start.left;
        }
        int max = 1;
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
                    if (n.left == null && n.right==null) {
                        max = Math.max(max, stack.size());
                    }
                    n = stack.pop();
                } while (!stack.isEmpty() && stack.peek().right == n);
            }
        }
        return max;
   
   
    }
}