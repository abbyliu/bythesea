package leecode.uniquebst;
/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * O(N2)
 */
public class Solution {
    public int numTrees(int n) {
    	int[] result = new int[n+1];
    	result[0] = 1; result[1] = 1;
    	for (int i = 2 ; i <=n; i++) {
    		for (int j = 0; j <i ;j++) {
    			result[i] = result[i] + result[j] * result[i-j-1];
    		}
    	}
    	return result[n];
    }
    
    public int numTrees2(int n) {
        if (n <=1) return 1;
        int v = 0;
        for (int i = 0; i <n ;i++) {
            int left = numTrees(i);
            int right = numTrees(n-i-1);
            v = v + left * right;
        }
        return v;
    }
    
    public static void main(String[] args) {
    	String p ="a".substring(1);
    	System.out.println(p.length());    }
}