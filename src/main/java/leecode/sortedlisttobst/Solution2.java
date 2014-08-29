package leecode.sortedlisttobst;

import leecode.postordertree.TreeNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode start = head;
        while (start != null) {
            len++;
            start = start.next;
        }
        node = head;
        return sortNode(len);
    }
    private TreeNode sortNode(int len) {
        if (len <=0) return null;
        if (len == 1) {
            ListNode next = node.next;
            TreeNode t = new TreeNode(node.val);
            node.next = null;
            node = next;
            return t;
        }
        TreeNode left = sortNode(len/2);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = left;
        root.right = sortNode(len - len/2-1);
        return root;
    }
}