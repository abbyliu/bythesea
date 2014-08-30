package leecode.bstfrominorderpostorder;

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length 
        != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        
        return build(map, inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode build(Map<Integer, Integer> map, int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend ) {
        if (instart > inend || poststart > postend) return null;
        int idx = map.get(postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = build(map, inorder, instart, idx-1, postorder, poststart, poststart + (idx-instart)-1);
        root.right = build(map, inorder, idx+1, inend, postorder, poststart+(idx-instart), postend-1);
        return root;
    }
    
}