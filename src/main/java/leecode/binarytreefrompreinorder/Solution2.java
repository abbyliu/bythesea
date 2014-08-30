package leecode.binarytreefrompreinorder;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < inorder.length;i++ ) {
            map.put(inorder[i], i);
        }
        return build(map, preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode build(Map<Integer, Integer> map, int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) return null;
        int idx = map.get(preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = build(map, preorder, inorder, prestart+1, prestart+1+ (idx-instart)-1, instart, idx-1);
        root.right = build(map, preorder, inorder, prestart + (idx-instart)+1, preend, idx+1, inend);
        return root;
    }
}