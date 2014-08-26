package leecode.reorderlist;

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
public class Solution2 {
    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        while (current != null) {
            ListNode back = current.next;
            current.next = pre;
            pre = current;
            current = back;
        }
        return pre;
    }
	public void reorderList(ListNode head) {
	    if (head == null || head.next == null) return;
	    
	    ListNode slow = head;
	    ListNode faster = head;
	    while (faster.next != null && faster.next.next !=null) {
	        slow = slow.next;
	        faster = faster.next.next;
	    }
	    
	    ListNode nNode = slow.next;
	    slow.next = null;
	    ListNode reversed = reverse(nNode);
	    
	    ListNode startA = head;
	    
	    while (reversed != null) {
	        ListNode back = startA.next;
	        startA.next = reversed;
	        reversed = reversed.next;
	        startA.next.next = back;
	        startA = back;
	    }
	}
	
}