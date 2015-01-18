package leecode.bstiterator;

import java.util.Stack;

import leecode.postordertree.TreeNode;

/* Binary Search Tree Iterator */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode start = root;
        while (start != null) {
            stack.push(start);
            start = start.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack under flow");
        }
        TreeNode node = stack.peek();
        int value = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        } else {
            do {
                node = stack.pop();
            } while (!stack.isEmpty() && stack.peek().right == node);
        }
        return value;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */