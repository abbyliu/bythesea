package leecode.insertionsortlinkedlist;


/* Insertion Sort List
 * Key takeaways
 * 1. Adding a dummy node for insertion simplify things
 * Sort a linked list using insertion sort.
 * 
 * O(n2)
 */

/*
 * Did not create a new linked list, working on existing one.
 * Key takeaways:
 * 1. need handle special cases
 */
public class SolutionTwo {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);dummy.next = head;
        ListNode current = head;
        ListNode preCurrent = dummy;
        while (current != null)  {
           ListNode pre = dummy;
     	   while (pre.next != current &&  pre.next.val <= current.val ) {
     		   pre = pre.next;
     	   }
     	   if (pre.next == current) {
         	   preCurrent = current;
         	   current = current.next;
     	   } else {
     		   ListNode nNode = current.next;
   			   preCurrent.next = nNode;
     		   ListNode next = pre.next;
     		   pre.next = current;
     		   current.next = next;
     		   current = nNode;
     	   }
        }
        return dummy.next;
     }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(3);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(4);
    	n1.next = n2;
    	n2.next = n3;
    	SolutionTwo s = new SolutionTwo();
    	n1 = s.insertionSortList(n1);
    	System.out.println(n1);
    }
}
