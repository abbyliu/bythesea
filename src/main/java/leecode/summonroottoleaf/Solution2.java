package leecode.summonroottoleaf;

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
    private int sum = 0;
    
    private void calcSum(TreeNode node, int val) {
        if (node == null) return;
        int v = val*10 + node.val;
        if (node.left == null && node.right == null) {
            sum += v;
        } else {
            calcSum(node.left, v);
            calcSum(node.right, v);
        }
    }
    public int sumNumbers(TreeNode root) {
        calcSum(root, 0);
        return sum;
    }

}