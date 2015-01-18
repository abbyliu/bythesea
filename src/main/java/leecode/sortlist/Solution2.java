package leecode.sortlist;

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

/* Sort List
 * O(nlogn)
 */


public class Solution2 {
    ListNode global = null;
    
    private int getLen(ListNode start) {
        int v = 0;
        
        while (start != null) {
            v++;
            start = start.next;
        }
        
        return v;
    }
    
    public ListNode sortList(ListNode head) {
        int v = getLen(head);
        
        if ( v <= 1) {
            return head;
        }
        
        global = head;
        
        return sort(v);
    }
    
    private ListNode sort(int num) {
        if (num == 1) {
            ListNode temp = global;
            global = global.next;
            temp.next = null;
            return temp;
        }
        ListNode p1 = sort(num/2);
        ListNode p2 = sort(num - num/2);
        return merge(p1, p2);
    }
    
    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (p1 != null && p2 != null) {
            if ( p1.val < p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        if (p1 != null) {
            pre.next = p1;
        } else {
            pre.next = p2;
        }
        
        return dummy.next;
    }
}