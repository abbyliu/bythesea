package leecode.reversenodeinkgroup;

import leecode.sortedlisttobst.ListNode;
/*
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null || k <=1) return head;
    	ListNode dummy = new ListNode(1);
    	
    	ListNode current = head;
    	int total = 0;
    	while (current != null) {
    		total++;
    		current = current.next;
    	}
    	
    	ListNode currentHead = head;
    	ListNode lastNode = dummy;
    	ListNode tail = null;
    	ListNode pre  = null;
    	for (int i = 0; i < total/k; i++) {
    		tail = currentHead;
    		current = currentHead.next;
    		pre = currentHead;
    		ListNode nextBack = null;
    		for (int j = 0; j < k-1 ;j++) {
    			nextBack= current.next;
    			current.next = pre;
    			pre = current;
    			current = nextBack;
    		}
    		currentHead = nextBack;
    		tail.next = null;
    		lastNode.next = pre;
    		lastNode = tail;
    	}
    	lastNode.next = currentHead;
    	return dummy.next;
    }
}
