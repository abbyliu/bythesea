package leecode.binarytreeupsidedown;

import leecode.postordertree.TreeNode;
/* Binary Tree Upside Down */
public class Solution {
	   public TreeNode UpsideDownBinaryTree(TreeNode root) {
	        TreeNode p = root, parent = null, parentRight = null;
	        while (p!=null) {
	            TreeNode left = p.left;
	            p.left = parentRight;
	            parentRight = p.right;
	            p.right = parent;
	            parent = p;
	            p = left;
	        }
	        return parent;
	    }
}
