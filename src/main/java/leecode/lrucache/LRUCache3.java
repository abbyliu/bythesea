package leecode.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {
    static class Node {
        int value;
        int key;
        Node pre;
        Node next;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    private int capacity = 0;
    Map<Integer, Node> map = null;
    Node dummy = null;
    public LRUCache3(int cap) {
        capacity = cap;
        map = new HashMap<>();
        dummy = new Node(-1,-1);
        dummy.pre = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (dummy.next != node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = dummy.next;
                node.pre = dummy;
                dummy.next = node;
                node.next.pre = node;
            }
            return node.value;
        } else {
            return -1;
        }
    }
    public void set(int k, int v) {
        Node n = null;
        if (map.containsKey(k)) {
            n = map.get(k);
            n.value = v;
        } else {
            n = new Node(k,v);
            if (map.size() >= capacity) {
                Node toRemove = dummy.pre;
                dummy.pre.pre.next = dummy;
                dummy.pre = dummy.pre.pre;
                map.remove(toRemove.key);
                toRemove = null;
            }
        }
        if (dummy.next != n) {
            if (n.next != null && n.pre != null) {
                n.next.pre = n.pre;
                n.pre.next = n.next;
            }
            dummy.next.pre = n;
            n.next = dummy.next;
            dummy.next = n;
            n.pre = dummy;
        }
        map.put(k, n);
    }
    

}
