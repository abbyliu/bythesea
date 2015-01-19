package leecode.populatenextright2;
/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".


What if the given tree could be any binary tree? Would your previous solution still work?
O(n)
 */
import leecode.populatenextright.TreeLinkNode;
/* Populating Next Right Pointers in Each Node II */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode leftWall = root;
        while (leftWall != null) {

            TreeLinkNode across = leftWall;
            TreeLinkNode toLink = null;
            TreeLinkNode nextLevelFirstNode = null;
            while (across != null) {
            	if (across.left != null) {
            		if (toLink!= null)	{
            			toLink.next = across.left;
            			toLink = across.left;
            		} else {
            		    toLink = across.left;
            		}
            		if (nextLevelFirstNode == null) {
            			nextLevelFirstNode = across.left;
            		} 
            	} 
            	if (across.right != null) {
            		if (toLink != null) {
            			toLink.next = across.right;
            			toLink = across.right;
            		} else {
            		    toLink = across.right;
            		}
            		if (nextLevelFirstNode == null) {
            			nextLevelFirstNode = across.right;
            		}
            	}
                across = across.next;
            }
            leftWall = nextLevelFirstNode;
        }
       
    }       
 }