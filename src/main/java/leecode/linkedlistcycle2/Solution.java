package leecode.linkedlistcycle2;

import leecode.sortedlisttobst.ListNode;

/**
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
	    if (head == null || head.next == null || head.next.next == null) return null;
	    ListNode slow = head.next;
	    ListNode fast = head.next.next;
	    while (slow != fast && fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    if (slow != fast) return null;
	    slow = head;
	    while (slow != fast) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    return slow;
	}
}