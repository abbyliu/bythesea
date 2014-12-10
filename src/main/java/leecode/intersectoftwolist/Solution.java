package leecode.intersectoftwolist;

public class Solution {
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
		 
    private int getLen(ListNode list) {
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        ListNode longer = null;
        ListNode shorter = null;
        if (lenA > lenB) {
            longer = headA;
            shorter = headB;
        } else {
            longer = headB;
            shorter = headA;
        }
        
        int diff = Math.abs(lenA - lenB);
        while (diff > 0) {
            longer = longer.next;
            diff--;
        }
        while (longer != shorter && longer != null && shorter != null) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }
}