package leecode.removeduplicatefromlist1;

import leecode.sortedlisttobst.ListNode;
/*  Remove Duplicates from Sorted List
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 
O(n)
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode previous = head;
    	ListNode current = head.next;
    	while(current != null) {
    		if (current.val == previous.val) {
    			previous.next = current.next;
    			current.next = null;
    			current = previous.next;
    		} else {
    			previous = current;
    			current = current.next;
    		}
    	}
    	return head;
    }
    
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode start = head;
        while (start != null) {
            if (start.next != null && start.next.val == start.val) {
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        return head;
    }
}