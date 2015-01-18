package leecode.reorderlist;


/* Reorder List
 * 
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
        if (head != null && head.next != null && head.next.next != null) {
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode reversed = reverse(slow.next);
            slow.next = null;
            
            ListNode start = head;
            while (reversed != null) {
                ListNode back = reversed.next;
                reversed.next = start.next;
                start.next = reversed;
                start = start.next.next;
                reversed = back;
            }
        }
    }
    
	
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
}