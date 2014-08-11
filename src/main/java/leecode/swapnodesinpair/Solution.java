package leecode.swapnodesinpair;

import leecode.sortedlisttobst.ListNode;
/*
 *  Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3. 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode swapPairs(ListNode head) {
    	ListNode dummy = new ListNode(1);
    	if (head == null || head.next == null) return head;
    	
    	ListNode previous = head;
    	ListNode next = head.next;
    	ListNode tail = dummy;
    	
    	ListNode nextBack = null;
    	while (next != null) {
    		nextBack = next.next;
    		next.next = previous;
    		previous.next = null;
    		tail.next = next;
    		tail = previous;

    		previous = nextBack;
    		if (previous == null || previous.next == null) {
    			break;
    		} else {
    			next = previous.next;
    		}
    	}
    	tail.next = previous;
    	return dummy.next;
    	
    }
}
