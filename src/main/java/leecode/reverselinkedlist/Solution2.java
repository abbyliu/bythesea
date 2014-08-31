package leecode.reverselinkedlist;

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) return head;
        int move = m-1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy; 
        while (move>0) {
            move--;
            start = start.next;
        }
        ListNode pre = null;
        ListNode current= start.next;
        int rev = n-m+1;
        while (rev >0) {
            ListNode back = current.next;
            current.next = pre;
            pre = current;
            current = back;
            rev--;
        }
        if (start.next != null) {
            start.next.next = current;
        }
        start.next = pre;
        return dummy.next;
    }

}