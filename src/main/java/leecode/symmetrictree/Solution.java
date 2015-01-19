package leecode.symmetrictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leecode.postordertree.TreeNode;
/* Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric: 
O(N)
 */
public class Solution {
    public boolean isSymmetricIterate(TreeNode root) {
    	if (root == null) return true;
    	Queue<TreeNode> nodes = new LinkedList<>();
    	Queue<TreeNode> tmp = new LinkedList<>();
    	nodes.offer(root);
    	List<Integer> values = new ArrayList<>();
    	TreeNode nill = new TreeNode(Integer.MIN_VALUE);
    	while (!nodes.isEmpty()) {
    		TreeNode node = nodes.poll();
    		values.add(node.val);
    		if (node.left != null) {
    			tmp.offer(node.left);
    		} else if (node != nill ){
    			tmp.offer(nill);
    		}
    		if (node.right != null) {
    			tmp.offer(node.right);
    		} else if (node != nill ){
    			tmp.offer(nill);
    		}
    		if (nodes.isEmpty() && !tmp.isEmpty()) {
    			nodes.addAll(tmp);
    			tmp.clear();
    			if (!checkValue(values)) {
    				return false;
    			}
    			values.clear();
    		}
    	}
    	return true;
    }
    
	private boolean checkValue(List<Integer> values) {
		if (values.size() > 1) {
			if (values.size() % 2 != 0) return false;
			for (int i = 0; i < values.size()/2;i++) {
				if (Integer.compare(values.get(i) ,values.get(values.size()-1-i)) != 0) {
					return false;
				}
			}
		}
		return true;
	}
}