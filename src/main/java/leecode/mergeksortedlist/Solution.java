package leecode.mergeksortedlist;

import java.util.ArrayList;
import java.util.List;

import leecode.sortedlisttobst.ListNode;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(-2);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		n1.next = n2;n2.next = n3;n3.next = n4;
		
		ListNode nn1 = new ListNode(-2);
		ListNode nn2 = new ListNode(5);
		ListNode nn3 = new ListNode(6);
		nn1.next = nn2;nn2.next = nn3;
		
		ListNode nnn1 = new ListNode(-2);
		ListNode nnn2 = new ListNode(0);
		nnn1.next = nnn2;
		
		List<ListNode> lll = new ArrayList<>();
		lll.add(n1);lll.add(nn1);lll.add(nnn1);
		
		Solution s = new Solution();
		s.mergeKLists(lll);
		
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size()==0) return null;
		if (lists.size() == 1) return lists.get(0);
		
		int length = lists.size();
		ListNode[] heap = new ListNode[lists.size()];
		int idx = 0;
		for (int i = 0; i < heap.length ; i++) {
			if (lists.get(i) != null) {
				heap[idx] = lists.get(i);
				idx++;
			}
		}
		length = idx;
		
		ListNode dummy = new ListNode(1);
		ListNode previous = dummy;
		for (int i = length/2-1; i>=0; i--) {
			heapify(heap, i, length);
		}
		while(length > 1) {
			previous.next = heap[0];
			previous = heap[0];
			heap[0] = heap[0].next;
			previous.next = null;
			if (heap[0] == null) {
				heap[0] = heap[length-1];
				length--;
			} 
			heapify(heap, 0, length);
		}
		previous.next = heap[0];
		return dummy.next;
	}

	private void heapify(ListNode[] heap, int i, int length) {
		int left = i * 2 +1;
		int right = i * 2 + 2;
		int small = i;
		if (left < length && heap[small].val > heap[left].val) {
			small = left;
		}
		if (right < length && heap[small].val > heap[right].val) {
			small = right;
		}
		if (small != i) {
			ListNode tmp = heap[i];
			heap[i] = heap[small];
			heap[small] = tmp;
			heapify(heap, small, length);
		}
	}
}
