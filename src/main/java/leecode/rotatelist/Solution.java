package leecode.rotatelist;

import leecode.sortedlisttobst.ListNode;
/* Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		s.rotateRight2(head, 1);
	}
	public ListNode rotateRight2(ListNode head, int n) {
		if (head == null || n == 0) return head;
		
		ListNode first = head;
		ListNode second = head;
		
		int len  = 0;
		while (first != null) {
			first = first.next;
			len++;
		}
		
		first = head;
		int move = n%len;
		
		while (second.next != null && move >0) {
			second = second.next;
			move--;
		}
		if (move != 0) return head;
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		
		second.next = head;
		ListNode ret = first.next;
		first.next = null;
		return ret;
		
	}
    public ListNode rotateRight(ListNode head, int n) {
    	if (head == null || n == 0) return head;
    	int len = 1;
    	ListNode start = head;
    	while (start.next != null) {
    		start = start.next;
    		len++;
    	}
    	start.next = head;
    	int move = len - (n % len)-1;
    	while (move > 0) {
    		head = head.next;
    		move--;
    	}
    	ListNode returns = head.next;
    	head.next = null;
    	return returns;
    }
}