package leecode.reorderlist;

import java.util.HashMap;
import java.util.Map;

/*
 *  Given a singly linked list L: L0->L1->...->Ln-1->Ln,
reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
 
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		s.reorderList2(head);
	}
	public void reorderList2(ListNode head) {
		if (head == null) return;
		
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast!=null) {
				fast = fast.next;
			}
		}
		
		ListNode newH = slow.next;
		ListNode pre = null;
		while (newH != null) {
			ListNode back = newH.next;
			newH.next = pre;
			pre = newH;
			newH = back;
		}
		newH = pre;
		slow.next = null;
	
		ListNode start = head;
		while (newH!=null) {
			ListNode back = start.next;
			start.next = newH;
			newH = newH.next;
			start.next.next = back;
			start = back;
		}
	}
    public void reorderList(ListNode head) {
        if (head == null) return;
        Map<Integer,ListNode> map = new HashMap<>();
        int i = 0;
        ListNode start = head;
        while (start != null) {
        	map.put(i, start);
        	start = start.next;
        	i++;
        }
        if (map.size() <= 2) return;
        for (int idx = 0; idx < map.size()/2; idx++) {
        	ListNode n1 = map.get(idx);
        	ListNode end = map.get(map.size() - idx -1);
        	n1.next = end;
        	end.next = map.get(idx+1);
        }
        int idx = map.size()/2;
        map.get(idx).next = null;
    }
}