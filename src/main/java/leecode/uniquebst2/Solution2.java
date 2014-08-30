package leecode.uniquebst2;

import java.util.ArrayList;
import java.util.List;

import leecode.postordertree.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution2 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        if (n == 0) {
            nodes.add(null);
            return nodes;
        }
        if (n == 1)  {
            nodes.add(new TreeNode(1));
            return nodes;
        }
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        if (start == end)  {
            nodes.add(new TreeNode(start));
            return nodes;
        }
        List<TreeNode> tn = new ArrayList<>();
        for (int i = start; i <=end; i++) {
            List<TreeNode> left = generate(start, i-1);
            List<TreeNode> right = generate(i+1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    tn.add(root);
                }
            }
        }
        return tn;
    }
    

}