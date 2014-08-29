package leecode.populatenextright;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode back = node;
            
            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                    if (node.next != null) {
                        node.right.next = node.next.left;
                    }
                }
                node = node.next;
            }
            node = back.left;
        }
        
    }        
  
}