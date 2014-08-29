package leecode.populatenextright2;

import leecode.populatenextright.TreeLinkNode;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode n = root;
        while (n != null) {
           TreeLinkNode nextLevel = null;
           TreeLinkNode toConnect = null;
           while (n!= null) {
               if (n.left != null) {
                   if (nextLevel == null) {
                       nextLevel = n.left;
                   }
                   if (toConnect == null) {
                       toConnect = n.left;
                   } else {
                       toConnect.next = n.left;
                       toConnect = n.left;
                   }
               }
               if (n.right != null) {
                   if (nextLevel == null) {
                       nextLevel = n.right;
                   }
                   if (toConnect == null) {
                       toConnect = n.right;
                   } else {
                       toConnect.next = n.right;
                       toConnect = n.right;
                   }
               }
               n = n.next;
           }
     
           n = nextLevel;
        }
    }
        
}