package leecode.sqrt;
/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
O(logX)
 */
public class Solution {
    public int sqrt(int x) {
    	if (x <= 0) return 0;
    	long start = 1;
    	long end = x;
    	while (start < end) {
    		long mid = start + (end-start)/2;
    		if (mid* mid > x) {
    			end = mid -1;
    		} else if (mid*mid == x) {
    			return (int)mid;
    		} else {
    			start = mid +1;
    		}
    	}
    	if (start * start > x) {
    		start--;
    	}
    	return (int)start;
    }
    public static void main(String[] args) {
    	Solution s= new Solution();
    	System.out.println(s.sqrt(2147395599));
    }
}