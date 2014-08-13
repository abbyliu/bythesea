package leecode.singlenumber;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * O(N)
 */
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return 0;
        int v = 0;
        for(int value: A ) {
        	v ^= value;
        }
        return v;
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {2, 2, 1, 1, 3};
    	Solution s = new Solution();
    	int v = s.singleNumber(a);
    	System.out.println(v);
    }
}