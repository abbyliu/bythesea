package leecode.mergetwosortedlist;

import leecode.sortedlisttobst.ListNode;
/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null ) return l2;
		if (l2 == null) return l1;
		ListNode dummy = new ListNode(1);
		ListNode pre = dummy;
		while (l1!=null && l2!= null) {
			if (l1.val<l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if (l1!=null) {
			pre.next = l1;
		}
		if (l2!=null) {
			pre.next = l2;
		}
		return dummy.next;
	}
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