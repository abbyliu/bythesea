package leecode.partitionlist;

import leecode.sortedlisttobst.ListNode;
/*
 * Given a linked list and a value x, partition it such that all nodes
 *  less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 

 */
public class Solution {
	public static void main(String[] args) {
		ListNode n = new ListNode(2);
		n.next = new ListNode(1);
		Solution s = new Solution();
		s.partition2(n, 2);
	}
    public ListNode partition2(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        ListNode preBig = null;
        while (current != null) {
            if (current.val < x) {
                if (preBig == null) {
                    pre = pre.next;
                    current = current.next;
                } else {
                    ListNode back = current.next;
                    current.next = preBig.next;
                    preBig.next = current;
                    preBig = current;
                    current = back;
                    pre.next = current;
                }
            } else {
                if (preBig == null) {
                    preBig = pre;
                }
                pre = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
	
    public ListNode partition(ListNode head, int x) {
    	ListNode  dummy = new ListNode(1);
    	dummy.next = head;
    	
    	ListNode current = head;
    	ListNode previousBig =dummy;
    	ListNode previousNode = dummy;
    	boolean foundBig = false;
    	while (current!= null) {
    		if (current.val < x) {
    			if (!foundBig) {
    				previousNode = current; 
    				current = current.next;
    			} else {
    				previousNode.next = current.next;
    				current.next = previousBig.next;
    				previousBig.next = current;
    				previousBig = current;
    				current = previousNode.next;
    			}
    		} else {
    			if (!foundBig) {
    				foundBig = true;
    				previousBig = previousNode;
    			}
    			previousNode = current;
    			current = current.next;
    		}
    	}
    	
    	return dummy.next;
    }
}