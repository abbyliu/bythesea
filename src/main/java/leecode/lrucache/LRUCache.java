package leecode.lrucache;

import java.util.HashMap;
import java.util.Map;

/* LRU Cache
 * 
 * Key takeaways:
 * 1. When move a node from the chain, has to remember not only add itself,
 * but also take care its original pre and next
 */

/*
 *  Design and implement a data structure for Least Recently Used (LRU) cache. 
 *  It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
 */
public class LRUCache {
	static class Node {
		int value;
		int key;
		Node next;
		Node pre;

		public Node(int key, int value, Node pre, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
			this.pre = pre;
		}
	}

	private Map<Integer, Node> map = null;
	private int capacity = 0;
	private Node dummyHead = null;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		dummyHead = new Node(0, 0, null, null);
		dummyHead.pre = dummyHead;
		dummyHead.next = dummyHead;
		if (capacity < 1) {
			throw new IllegalArgumentException("capacity cannot smaller than 1");
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			if (dummyHead.next != n) {
				n.pre.next = n.next;
				n.next.pre = n.pre;

				dummyHead.next.pre = n;
				n.next = dummyHead.next;
				n.pre = dummyHead;
				dummyHead.next = n;
			}
			return n.value;

		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		Node newNode = null;
		if (!map.containsKey(key)) {
			if (this.capacity == map.size()) {
				Node n = dummyHead.pre;
				n.pre.next = dummyHead;
				dummyHead.pre = n.pre;
				map.remove(n.key);
			}
			newNode = new Node(key, value, null, null);
		} else {
			newNode = map.get(key);
			newNode.value = value;
		}

		if (dummyHead.next != newNode) {
			if (newNode.pre != null && newNode.next != null) {
				newNode.pre.next = newNode.next;
				newNode.next.pre = newNode.pre;
			}
			dummyHead.next.pre = newNode;
			newNode.next = dummyHead.next;
			newNode.pre = dummyHead;
			dummyHead.next = newNode;
		}
		map.put(key, newNode);
	}

}
