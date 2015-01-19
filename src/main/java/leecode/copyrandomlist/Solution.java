package leecode.copyrandomlist;

import java.util.HashMap;
import java.util.Map;
/*  Copy List with Random Pointer
 *  A linked list is given such that each node contains an additional random 
 *  pointer which could point to any node in the list or null.
 *  Return a deep copy of the list. 
 *  
 *  O(n), O(n)
 */
public class Solution {

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
    

}