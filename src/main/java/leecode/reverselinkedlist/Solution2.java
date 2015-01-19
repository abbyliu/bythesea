package leecode.reverselinkedlist;

import leecode.sortedlisttobst.ListNode;
/*  Reverse Linked List II
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 <= m <= n <= length of list. 
 */
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