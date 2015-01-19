package leecode.partitionlist;

import leecode.sortedlisttobst.ListNode;
/*  Partition List
 *  Given a linked list and a value x, partition it such that all nodes
 *  less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
O(n)

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