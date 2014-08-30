package leecode.binarytreeleveltraverse;

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
   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Deque<TreeNode> q  =new LinkedList<>();
        q.offer(root);
        Deque<TreeNode> tmp = new LinkedList<>();
        List<Integer> dt = new ArrayList<>();
        ret.add(dt);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            ret.get(ret.size()-1).add(n.val);
            if (n.left != null) {
                tmp.offer(n.left);
            }
            if (n.right != null) {
                tmp.offer(n.right);
            }
            if (q.isEmpty()) {
                q = tmp;
                tmp = new LinkedList<>();
                if (!q.isEmpty()) {
                    ret.add(new ArrayList<Integer>());
                }
            }
        }
        
        return ret;
 
   }
}