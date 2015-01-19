package leecode.summonroottoleaf;

import java.util.Stack;

/* Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.
O(N)
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
    	if (root == null) return 0;
    	
    	int v = findLeafsumNoRecursion(root,0);
    	return v;
    }

    static class NodeV {
    	TreeNode tree;
    	int carry;
    	public NodeV(TreeNode t, int c) {
    		tree =t ;
    		carry = c;
    	}
    }
    private int findLeafsumNoRecursion(TreeNode root, int start) {
    	Stack<NodeV> stack = new Stack<>();
    	stack.add(new NodeV(root, start));
    	
    	int result = 0;
    	while (!stack.isEmpty()) {
    		NodeV v = stack.pop();
    		if (v.tree.left == null && v.tree.right == null) {
    			result += v.carry * 10 + v.tree.val;
    		} else {
    			if (v.tree.left != null) {
    				stack.push(new NodeV(v.tree.left, v.carry*10 + v.tree.val));
    			}
    			if (v.tree.right != null) {
    				stack.push(new NodeV(v.tree.right, v.carry * 10 + v.tree.val));
    			}
    		}
    	}
    	return result;
    }
    
	
}