package leecode.removeduplicatesfromlist;

import leecode.sortedlisttobst.ListNode;
/*
 *  Given a sorted linked list, delete all nodes that have duplicate numbers, 
 *  leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 
O(N)
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) return head;
    	
    	ListNode dummy = new ListNode(1);
    	dummy.next = head;
    	ListNode previous = dummy;
    	ListNode current = head;
    	while ( current != null) {
    		boolean deleteCurrent = false;
    		while (current.next != null && current.next.val == current.val) {
    			deleteCurrent = true;
    			current.next = current.next.next;
    		}
    		if (deleteCurrent) {
    			previous.next = current.next;
    			current = previous.next;
    		} else {
    			previous = current;
    			current = current.next;
    		}
    	}
    	return dummy.next;
    }
}