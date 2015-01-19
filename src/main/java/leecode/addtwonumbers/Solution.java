package leecode.addtwonumbers;

import leecode.sortedlisttobst.ListNode;

/* Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 O(l1.length + l2.length)
 
*/
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2, 0);
    }
    public ListNode addTwoNumber3(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null) return null;
    	if (l1 == null ) return l2;
    	if (l2 == null) return l1;
    	
    	ListNode dummy = new ListNode(1);
    	int carry = 0;
    	ListNode previous = dummy;
    	while (l1 != null || l2 != null) {
    		int value = carry;
    		if (l1!= null) {
    			value += l1.val;
    			l1 = l1.next;
    		}
    		if (l2 != null) {
    			value += l2.val;
    			l2 = l2.next;
    		}
    		
    		ListNode newNode = new ListNode(value%10);
    		carry = value/10;
    		previous.next = newNode;
    		previous = newNode;
    	}
    	if (carry >0) {
    		ListNode tail = new ListNode(carry);
    		previous.next = tail;
    	}
    	return dummy.next;
    }

    
	private ListNode add(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) return null;
		int v = carry;
		if (l1 != null) {
			v += l1.val;
		}
		if (l2!= null) {
			v+= l2.val;
		}
		ListNode node = new ListNode(v);
		if (v>=10) {
			node.val = v%10;
		} 
		
		node.next = add(l1!= null? l1.next:null, l2!= null? l2.next:null, v >= 10? 1:0);
		
		return node;
	}
}
