package leecode.insertionsortlinkedlist;

public class Solution2 {
    public ListNode insertionSortList(ListNode head) {
       if (head == null || head.next == null) return head;
       ListNode dummy = new ListNode(-1); dummy.next = head; 
       ListNode preCurrent = dummy;
       ListNode current = head;
       while (current != null) {
           ListNode start = dummy.next;
           ListNode pre = dummy;
           while (start.val < current.val && start != current) {
               start = start.next;
               pre = pre.next;
           }
           if (start == current) {
               preCurrent = current;
               current = current.next;
           } else {
               ListNode back = current.next;
               current.next = start;
               pre.next = current;
               current = back;
               preCurrent.next = current;
           }
           
       }
       return dummy.next;
  }
   
}