package leecode.populatenextright;
/*  Populating Next Right Pointers in Each Node
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