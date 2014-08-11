package leecode.mergeksortedlist;

import java.util.ArrayList;
import java.util.List;

import leecode.sortedlisttobst.ListNode;

public class S2 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n0 = new ListNode(0);
		List<ListNode> ns =new ArrayList<>();
		ns.add(n1);ns.add(n0);
		S2 s2  = new S2();
		s2.mergeKLists(ns);
	}
	   public ListNode mergeKLists(List<ListNode> lists) {
	        if (lists == null || lists.size() == 0) return null;
	        List<ListNode> copy = new ArrayList<>();
	        for (ListNode l: lists) {
	            if (l != null) {
	                copy.add(l);
	            }
	        }
	        ListNode dummy = new ListNode(1);
	        ListNode pre = dummy;
	        int size = copy.size();
	        for (int i = (size-1)/2; i>=0;i--) {
	            heapify(i, copy, size);
	        }
	        while (size >1) {
	            pre.next = copy.get(0);
	            pre = pre.next;
	            ListNode back = pre.next;
	            pre.next = null;
	            if (back == null) {
	                copy.set(0, copy.get(size-1));
	                size--;
	            } else {
	                copy.set(0, back);
	            }
	            heapify(0, copy, size);
	        }
	        if (size ==1)
	         pre.next = copy.get(0);
	        return dummy.next;
	    }
	    
	    private void heapify(int i, List<ListNode> lists, int size) {
	        int left = i * 2+1;
	        int right = i * 2 + 2;
	        int min = i;
	        if (left < size) {
	            if (lists.get(left).val < lists.get(min).val) {
	                min = left;
	            }
	        }
	        if (right < size) {
	            if (lists.get(right).val < lists.get(min).val) {
	                min = right;
	            }
	        }
	        
	        if (min != i) {
	            ListNode tmp = lists.get(i);
	            lists.set(i, lists.get(min));
	            lists.set(min, tmp);
	            heapify(min, lists, size);
	        }
	    }
}
