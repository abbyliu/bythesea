package leecode.insertionsortlinkedlist;

/*
 * Key takeaways
 * 1. Adding a dummy node for insertion simplify things
 * Sort a linked list using insertion sort.
 * 
 * O(n2)
 */
public class Solution {
	public ListNode insertionSortList2(ListNode head) {
		if (head == null ||head.next == null) return head;
		ListNode dummy = new ListNode(1);
		
		ListNode current = head;
		while (current != null) {
			ListNode start = dummy;
			while (start.next != null && start.next.val <= current.val) {
				start= start.next;
			}
			ListNode back = current.next;
			current.next = start.next;
			start.next = current;
			current = back;
		}
		return dummy.next;
	}
	
    public ListNode insertionSortList(ListNode head) {
       if (head == null || head.next == null) return head;
       
       ListNode start = head;
       ListNode dummy = new ListNode(-1);dummy.next = null;
       while (start != null)  {
    	   ListNode node = start;
    	   start = start.next;
    	   node.next = null;
    	   
    	   ListNode pre = dummy;
    	   while (pre.next != null &&  pre.next.val < node.val ) {
    		   pre = pre.next;
    	   }
    	   if (pre.next == null) {
    		   pre.next = node;
    	   } else {
    		   ListNode next = pre.next;
    		   pre.next = node;
    		   node.next = next;
    	   }
       }
       return dummy.next;
    }
}
