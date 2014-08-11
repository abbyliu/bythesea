package leecode.reverselinkedlist;

import leecode.sortedlisttobst.ListNode;

/*
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list. 
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null) return head;
    	if (m > n ) return head;
    	if (m == n) return head;
    	
    	ListNode dummy =new ListNode(1);
    	dummy.next = head;
    	ListNode previous = dummy;
    	int idx = 1;
    	while (idx < m  && previous != null) {
    		previous = previous.next;
    		idx++;
    	}
    	
    //	if (previous == null && idx != m) return head;
    	
    	int flip = n - m +1;
    	ListNode old = null;
    	ListNode current = previous.next;
    	while (current != null && flip > 0) {
    		ListNode back = current.next;
    		current.next = old;
    		old = current;
    		current = back;
    		flip--;
    	}
    	
//    	if (flip == 0) {
    		previous.next.next = current;
    		previous.next = old;
  //  	}
    	return dummy.next;
    	
    }
}