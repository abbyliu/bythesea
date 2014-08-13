package leecode.sortlist;

/*
 * O(nlogn)
 */
public class Solution {

	   ListNode hd = null;
	   public ListNode sortList2(ListNode head) {
	        if (head == null || head.next == null) return head;
	        
	        int len = 0;
	        ListNode current = head;
	        while (current!= null) {
	          len++;
	          current = current.next;
	        }
	        hd = head;
	        return mergeSort(len);
	    
	    }
	    
	    private ListNode mergeSort(int len) {
	       if (len == 1) {
	    	   ListNode tmp = hd;
	           hd = hd.next;
	           tmp.next = null;
	           return tmp;
	       }

	       ListNode firstHalf = mergeSort(len/2);
	       ListNode secondHalf = mergeSort(len - len/2);
	       return merge(firstHalf, secondHalf);
	    
	    }
	    
	    private ListNode merge(ListNode first, ListNode second) {
	       
	       ListNode dummy = new ListNode(1);
	       ListNode current = dummy;
	       while (first != null && second!= null) {
	          if (first.val < second.val) {
	              current.next = first;
	              first = first.next;
	          } else {
	              current.next = second;
	              second = second.next;
	          }
	          current = current.next;
	       }
	       if (first != null) {
	          current.next = first;
	       } else {
	          current.next = second;
	       }
	        return dummy.next;
	    }
	
	

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int i = 0;
        ListNode pointer = head;
        while (pointer != null) {
        	i++;
        	pointer = pointer.next;
        }
        return sortListWithNumber(head, i);
    }
	
    private ListNode sortListWithNumber(ListNode head, int n) {
    	if (n == 0 || n == 1) return head;
    	int mid = n/2;
    	int i = 1;
    	ListNode pointer = head;
    	while (pointer != null && i < mid) {
    		pointer = pointer.next;
    		i++;
    	}
    	
    	ListNode next = pointer.next;
    	pointer.next = null;
    	ListNode a = sortListWithNumber(head, i);
    	ListNode b = sortListWithNumber(next, n-i);
    	
    	ListNode newHead = null;
    	ListNode current = null;
    	while ( a != null && b != null) {
    		ListNode smaller = null;
    		if (a.val < b.val) {
    			smaller = a;
    			a = a.next;
    		} else {
    			smaller = b;
    			b = b.next;
    		}
    		if (current == null) {
    			newHead = smaller;
    			current = smaller;
    		} else {
    			current.next = smaller;
    			current = current.next;
    		}
    	}
    	
    	while (a != null) {
    		if (current == null) {
    			newHead = a;current = a;
    		} else {
	    		current.next = a;
	    		current = current.next;
    		}
    		a  = a.next;
    	}
    	while (b != null) {
    		if (current == null) {
    			newHead = b;current = b;
    		} else {
	    		current.next = b;
	    		current = current.next;
    		}
    		b = b.next;
    	}
    	return newHead;
    }

    public static void main(String[] args) {
    	ListNode n1 = new ListNode(2);
    	n1.next = new ListNode(1);
    	Solution s = new Solution();
    	s.sortList2(n1);
    }
}
