package leecode.populatenextright;

public class Solution2 {
    public void connect(TreeLinkNode root) {
    	if (root == null) return;
    	TreeLinkNode start = root;
    	TreeLinkNode end = root;
    	TreeLinkNode levelEnd = root;
    	while (start != null) {
    		if (start.left != null) {
    			end.next = start.left;
    			end = end.next;
    		}
    		if (start.right != null) {
    			end.next = start.right;
    			end = end.next;
    		}
    		if (start == levelEnd) {
    			start = start.next;
    			levelEnd.next = null;
    			levelEnd = end;
    		} else {
    			start = start.next;
    		}
    	}
    }
}
