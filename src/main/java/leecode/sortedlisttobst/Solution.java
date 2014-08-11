package leecode.sortedlisttobst;

import leecode.postordertree.TreeNode;
/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 */
public class Solution {
		private ListNode list;
	    public TreeNode sortedListToBST(ListNode head) {
	    	if (head == null) return null;
	    	int n = 0;
	    	ListNode start = head;
	    	while(start != null) {
	    		start = start.next;
	    		n++;
	    	}
	    	list = head;
	    	return tobst(0, n-1);
	    }

		private TreeNode tobst(int i, int j) {
			if (i > j) return null;
			int mid = i + (j-i)/2;
			TreeNode left = tobst(i, mid-1);
			TreeNode root = new TreeNode(list.val);
			root.left = left;
			list = list.next;
			root.right = tobst(mid+1, j);
			return root;
		}
}
