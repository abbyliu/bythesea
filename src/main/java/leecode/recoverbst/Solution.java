package leecode.recoverbst;

import leecode.postordertree.TreeNode;
/*  Recover Binary Search Tree
 *  Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
O(N)
 */
public class Solution {
	
	public void recoverTree(TreeNode root) {
		
		if (root == null) return;

		TreeNode r1 = null;
		TreeNode r2 = null;
		TreeNode previous = null;
		while(root !=null) {
			if (previous != null && previous.val > root.val) {
				if (r1 == null) {
					r1 = previous;
				}
				r2 = root;
			}
			if (root.left ==  null) {
				previous = root;
				root = root.right;
			} else {
				TreeNode left = root.left;
				while (left.right != null && left.right != root) {
					left = left.right;
				}
				if (left.right == null) {
					left.right = root;
					root = root.left;
				} else {
					left.right = null;
					previous = root;
					root = root.right;
				}
			}
		}
		if (r1 != null && r2 != null) {
			int tmp = r2.val;
			r2.val = r1.val;
			r1.val = tmp;
		}
	}
    public static void main(String[] args) {
    	TreeNode root=  new TreeNode(2);
    	root.right = new TreeNode(1);
    	Solution s = new Solution();
    	s.recoverTree(root);
    }
}