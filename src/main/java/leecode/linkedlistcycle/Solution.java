package leecode.linkedlistcycle;
/* Linked List Cycle
 * 
O(n)
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
    
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slower = head.next;
        ListNode faster = head.next.next;
        while (slower != faster && faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
        }
        
        return slower == faster;
    }
}