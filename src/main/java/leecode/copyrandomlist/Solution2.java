package leecode.copyrandomlist;
public class Solution2 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode start = head;
        while (start != null) {
            RandomListNode copy = new RandomListNode(start.label);
            copy.next = start.next;
            start.next = copy;
            start = start.next.next;
        }
        
        start = head;
        while (start != null) {
            if (start.random!= null) {
                start.next.random = start.random.next;
            }
            start = start.next.next;
        }
        
        RandomListNode newhead = head.next;
        start =head;
        RandomListNode start2 = newhead;
        while (start != null) {
            if (start.next != null) {
                start.next = start.next.next;
            } 
            start = start.next;
            if (start2.next != null) {
                start2.next = start2.next.next;
            }
            start2 = start2.next;
        }
        return newhead;
    }
}