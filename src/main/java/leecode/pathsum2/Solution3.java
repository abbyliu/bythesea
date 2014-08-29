package leecode.pathsum2;

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
public class Solution3 {
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> result = new ArrayList<>();
       if (root == null) return result;
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
                if (t.left == null && t.right == null && v == sum) {
                    List<Integer> ret = new ArrayList<>();
                    for (TreeNode tt: q) {
                        ret.add(0,tt.val);
                    }
                    result.add(ret);
                }
                do {
                    t = q.pop();
                    v -=t.val;
                } while (!q.isEmpty() && q.peek().right == t) ;
            }
        }
        return result;
    }
}