package leecode.mergetwosortedlist;

import leecode.sortedlisttobst.ListNode;
/* Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *O(M+n)
 */
public class Solution {
	

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy  = new ListNode(1);
    	ListNode first = l1;
    	ListNode second = l2;
    	ListNode current = dummy;
    	while ( first != null && second != null) {
    		if (first.val < second.val) {
    			current.next = first;
    			first = first.next;
    		} else {
    			current.next = second;
    			second = second.next;
    		}
			current.next.next = null;
			current = current.next;
    	}
    	if (first != null) {
    		current.next = first;
    	}
    	if (second != null) {
    		current.next = second;
    	}
    	return dummy.next;
    }
}