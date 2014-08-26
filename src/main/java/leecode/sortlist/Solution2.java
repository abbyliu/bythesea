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
public class Solution2 {
 	   ListNode global = null;
	   public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) return head;
	        int len = 0;
	        ListNode start = head;
	        while (start != null) {
	            len ++;
	            start = start.next;
	        }
	        global = head;
	        return mergeSort(len);
	   }
	        
	   private ListNode mergeSort(int len) {
	       if (len ==1) {
	           ListNode save = global;
	           global = global.next;
	           save.next = null;
	           return save;
	       }
	       
	       ListNode left = mergeSort(len/2);
	       ListNode right = mergeSort(len - len/2);
	       
	       ListNode ret = new ListNode(-1);
	       ListNode current = ret;
	       while (left != null && right != null) {
	           if (left.val < right.val) {
	               current.next = left; left = left.next;   
	           } else {
	               current.next = right; right = right.next;
	           }
	           current = current.next;
	       }
	       if (left != null) {
	           current.next = left;
	       } else {
	           current.next = right;
	       }
	       return ret.next;
	   }
}