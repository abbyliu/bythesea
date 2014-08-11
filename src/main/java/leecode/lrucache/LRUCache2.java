package leecode.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
	 static class Node {
	      int v ;
	      int k;
	      Node pre;
	      Node next;
	      public Node(int kk, int vv) {
	        this.k = kk;
	        this.v = vv;
	      }
	   }
	   
	   int cap = 0;
	   Node dummy = null;
	   Map<Integer, Node> map = new HashMap<>();

	   public LRUCache2(int capacity) {
	        cap = capacity;
	        dummy = new Node(0,0);
	        dummy.next = dummy;
	        dummy.pre = dummy;
	    }
	    
	    public int get(int key) {
	        if (map.containsKey(key)) {
	            Node n = map.get(key);
	           if (dummy.next != n) {
	               n.pre.next = n.next;
	               n.next.pre = n.pre;
	               n.next = dummy.next;
	               n.next.pre = n;
	               n.pre = dummy;
	               dummy.next = n;
	               
	           }
	           return n.v;
	        } else {
	         return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	        Node n = null;
	        if (map.containsKey(key)) {
	            n = map.get(key);
	            n.v = value;
	        } else {
	            if (map.size() >= cap) {
	                n = dummy.pre;
	                n.pre.next = dummy;
	                dummy.pre = n.pre;
	                map.remove(n.k);
	                n = null;
	            }
	            n = new Node(key, value);
	        }
	        if (n.next != null && n.pre != null) {
	           n.pre.next = n.next;
	           n.next.pre = n.pre;
	        }
	        if (dummy.next != n) {
	            n.next = dummy.next;
	            n.next.pre = n;
	            dummy.next = n;
	            n.pre = dummy;
	        }
	        map.put(key, n);
	    }
}
