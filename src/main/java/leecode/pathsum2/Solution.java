package leecode.pathsum2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leecode.postordertree.TreeNode;
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 * O(N)
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;
    	
    	List<Integer> tmp = new ArrayList<>();
    	findAllPaths(root, sum, result, tmp);
    	return result;
    }
    
	private void findAllPaths(TreeNode root, int sum,
			List<List<Integer>> result, List<Integer> tmp) {
		if (root.left == null && root.right == null && root.val == sum) {
			tmp.add(root.val);
			result.add(tmp);
			return;
		}
		if (root.left != null) {
			List<Integer> copy = new ArrayList<>(tmp);
			copy.add(root.val);
			findAllPaths(root.left, sum - root.val, result, copy);
		}
		if (root.right != null) {
			List<Integer> copy = new ArrayList<>(tmp);
			copy.add(root.val);
			findAllPaths(root.right, sum - root.val, result, copy);
		}
	}
	
	   public List<List<Integer>> pathSumNoneRecursive(TreeNode root, int sum) {
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
