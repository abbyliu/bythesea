package leecode.partitionlist;

import leecode.sortedlisttobst.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution2 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        ListNode preBig = null;
        ListNode pre = dummy;
        boolean foundBigger = false;
        while (current != null) {
            if (current.val >= x) {
                if (!foundBigger) {
                    foundBigger = true;
                    preBig = pre;
                }
            } else if (current.val < x) {
                if (foundBigger) {
                    pre.next = current.next;
                    current.next = preBig.next;
                    preBig.next = current;
                    preBig = current;
                    current = pre.next;
                    continue;
                }
            }
            pre = current; 
            current = current.next;
        }
        return dummy.next;
    }
}