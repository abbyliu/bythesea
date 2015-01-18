package leecode.linkedlistcycle2;

import leecode.sortedlisttobst.ListNode;

/** Linked List Cycle II
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
	    if (head == null ||head.next == null) {
	        return null;
	    }
	    
	    ListNode slower = head.next;
	    ListNode faster = head.next.next;
	    while (slower != faster && faster!= null && faster.next != null) {
	        slower = slower.next;
	        faster = faster.next.next;
	    }
	    
	    if (slower != faster) {
	        return null;
	    }
	    
	    slower = head;
	    while (slower != faster) {
	        slower = slower.next;
	        faster = faster.next;
	    }
	    
	    return slower;
	}
}