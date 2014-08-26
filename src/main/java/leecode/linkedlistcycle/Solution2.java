package leecode.linkedlistcycle;

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
    
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode slow = head.next;
        ListNode faster = head.next.next;
        while (slow != faster && faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }
        return slow == faster;
    }
}