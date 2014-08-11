package leecode.copyrandomlist;

import java.util.HashMap;
import java.util.Map;
/*
 *  A linked list is given such that each node contains an additional random 
 *  pointer which could point to any node in the list or null.
 *  Return a deep copy of the list. 
 *  
 *  O(n), O(n)
 */
public class Solution {
	public RandomListNode copyRandomList3(RandomListNode head) {
		if (head == null) return null;
		RandomListNode start = head;
		while (start != null) {
			RandomListNode dup = new RandomListNode(start.label);
			dup.next = start.next;
			start.next = dup;
			start = dup.next;
		}
		
		start = head;
		while (start != null) {
			if (start.random != null) {
				start.next.random = start.random.next;
			}
			start = start.next.next;
		}
		
		RandomListNode returns = head.next;
		start = head;
		RandomListNode start2 = start.next;
		while (start != null) {
			start.next = start.next.next;
			start = start.next;
			if (start != null) {
				start2.next = start.next;
			}
			start2 = start2.next;
		}
		return returns;
	}
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		
		// copy next
		RandomListNode start = head;
		while (start != null)  {
			RandomListNode dup = new RandomListNode(start.label);
			RandomListNode next = start.next;
			start.next = dup;
			dup.next = next;
			start = next;
		}
		
		// copy random
		start = head;
		while (start != null) {
			RandomListNode dup = start.next;
			if (start.random != null) {
				dup.random = start.random.next;
			}
			start = dup.next;
		}
		
		// break link between original and copy
		start = head;
		RandomListNode start2 = head.next;
		RandomListNode save2 = head.next;
		while (start != null && start.next != null) {
			start.next = start.next.next;
			start = start.next;
			if (start2.next != null) {
				start2.next = start2.next.next;
			} else {
				start2.next = null;
			}
			start2 = start2.next;
		}
		return save2;
	}
	
    public RandomListNode copyRandomList2(RandomListNode head) {
    	if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode start = new RandomListNode(head.label);
        
        RandomListNode current = head.next;
        RandomListNode newCurrent = start;
    	map.put(head, newCurrent);
        while (current != null) {
        	newCurrent.next = new RandomListNode(current.label);
        	newCurrent = newCurrent.next;
        	map.put(current, newCurrent);
        	current = current.next;
        }
        
        current = head;
        while (current != null) {
        	RandomListNode random = current.random;
        	if (random != null)  {
        		RandomListNode newNode = map.get(current);
        		newNode.random  = map.get(random);
        	}
        	current = current.next;
        }
        return start;
    }
    
    public RandomListNode copyRandomList4(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode current = head;
        while (current != null) {
            RandomListNode copy = new RandomListNode(current.label);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }
        
        current = head;
        while( current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        RandomListNode copyH = head.next;
        current = head;
        while (current != null) {
            RandomListNode back = current.next;
            current.next = current.next.next;
            current = current.next;
            if (current!=null) {
                back.next = current.next;
            } 
        }
        return copyH;
    }
}