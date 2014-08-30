package leecode.recoverbst;


import leecode.postordertree.TreeNode;


public class Solution2 {
	
	public void recoverTree(TreeNode root) {
	    if (root == null) return;
	    
	    TreeNode p1 = null;
	    TreeNode p2 = null;
	    
	    TreeNode current = root;
	    TreeNode pre = null;
	    
	    while (current != null) {
	        if (pre != null && pre.val > current.val) {
	            if ( p1 == null) {
	                p1 = pre;p2 = current;
	            } else {
	                p2 = current;
	            }
	        }
	        if (current.left == null) {
	            pre = current;
	            current = current.right;
	        } else {
	            TreeNode n = current.left;
	            while (n. right != null && n.right != current) {
	                n = n.right;
	            }
	            if (n.right == null) {
	                n.right = current;
	                current = current.left;
	            } else {
	                n.right = null;
	                pre = current;
	                current = current.right;
	            }
	        }
	    }
	    
	    if (p1 != null && p2 != null) {
	        int v = p1.val;
	        p1.val = p2.val;
	        p2.val = v;
	    }
	}

}