package leecode.populatenextright;
/*
 *  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
O(n)
 */
public class Solution {
	public void connect2(TreeLinkNode root) {
		if (root == null) return;
		
		TreeLinkNode left = root;
		while (left != null) {
			TreeLinkNode cross = left;
			while (cross!=null) {
				cross.left.next = cross.right;
				if (cross.right != null && cross.next != null) {
					cross.right.next = cross.next.left;
				}
				cross = cross.next;
			}
			left = left.left;
		}
		
	}
    public void connect(TreeLinkNode root) {

        TreeLinkNode leftWall = root;
        while (leftWall != null) {

            TreeLinkNode across = leftWall;
            while (across != null) {
                if (across.left != null) {
                    across.left.next = across.right;
                }

                if (across.right != null && across.next != null) {
                    across.right.next = across.next.left;
                }

                across = across.next;
            }
            leftWall = leftWall.left;
        }
    }
}