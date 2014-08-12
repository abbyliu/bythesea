package leecode.removenthelementfromlist;

import leecode.sortedlisttobst.ListNode;
/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * O(N)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null || n == 0) return head;
		int move = n-1;
		ListNode dummy = new ListNode(1);
		dummy.next = head;
		ListNode toRemove = head;
		while (toRemove!= null && move>0) {
			toRemove = toRemove.next;
			move--;
		}
		ListNode pre = dummy;
		while (toRemove.next != null) {
			toRemove = toRemove.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return dummy.next;
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || n == 0) return head;
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode pre = dummy;
        
        ListNode start = head;
        int num = n-1;
        while(start != null && num > 0) {
        	start = start.next;
        	num--;
        }
        while (start.next != null) {
        	pre = pre.next;
        	start = start.next;
        }
        ListNode save = pre.next;
        pre.next = pre.next.next;
        save.next = null;
        return dummy.next;
        
    }
}
