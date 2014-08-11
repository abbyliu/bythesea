package leecode.linkedlistcycle;
/*
 * O(n)
 * O(1)
 */
/*
 * 1. Given a linked list, determine if it has a cycle in it. 
 * 2. Given a linked list, return the node where the cycle begins. If there is no cycle, return null. 
 */

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
	public ListNode detectCycle2(ListNode head) {
    	if (head == null || head.next == null ) return null;
    	ListNode slow = head.next;
    	ListNode fast = head.next.next;
    	while (fast != null && fast.next != null && fast != slow) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	if (fast == null || fast.next == null) return null;
    	
    	slow = head;
    	while (slow!= fast) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return slow;
	}
	
    public ListNode detectCycle(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slower = head.next;
        ListNode faster = head.next.next;
        while (faster != null && faster.next!= null && faster.next.next!= null && faster != slower) {
        	faster = faster.next.next;
        	slower = slower.next;
        }
        
        if (faster == null || faster.next == null || faster.next.next == null) {
        	return null;
        }
        slower = head;
        while (slower != faster) {
        	slower = slower.next;
        	faster = faster.next;
        }
        return slower;
        
    }
    
    public boolean hasCycle2(ListNode head) {
    	if (head == null || head.next == null) return false;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while (fast != null && fast.next != null && fast != slow) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	if (fast == null || fast.next == null) return false;
    	return true;
    }
    
    public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) return false;
    	ListNode slow = head.next;
    	ListNode faster = head.next.next;
    	while ( faster != null && faster.next != null && faster.next.next != null && slow != faster) {
    		faster = faster.next.next;
    		slow = slow.next;
    	}
    	if ( faster == null || faster.next == null || faster.next.next == null) return false;
    	return true;
    }
}