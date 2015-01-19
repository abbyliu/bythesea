package leecode.climbingstairs;

/* Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?	 
	O(n), O(1), use fibonacci formular O(logn)
 */
public class Solution {
	public int climbStairs2(int n) {
		int a = 1;
		int b = 1;
		int result = 1;
		for (int i = 2; i <= n ;i++) {
			result = a+b;
			a = b;
			b = result;
		}
		return result;
	}
    public int climbStairs(int n) {
    	int[] result = new int[n+1];
    	result[0] = 1;
    	result[1] = 1;
    	for (int i = 2; i < result.length ;i++) {
    		result[i] = result[i-1] + result[i-2];
    	}
    	return result[n];
    }  
}