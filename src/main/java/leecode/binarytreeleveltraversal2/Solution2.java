package leecode.binarytreeleveltraversal2;

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
public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> q = new LinkedList<>();
        Deque<TreeNode> tmp = new LinkedList<>();
        q.offer(root);
        List<Integer> now = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode r = q.poll();
            now.add(r.val);
            if (r.left != null) {
                tmp.offer(r.left);
            }
            if (r.right != null) {
                tmp.offer(r.right);
            }
            if (q.isEmpty()) {
                q = tmp;
                tmp = new LinkedList<>();
                result.add(0, now);
                now = new ArrayList<>();
            }
        }
        return result;
    }
        
}