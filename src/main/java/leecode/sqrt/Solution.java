package leecode.sqrt;
/* Sqrt(x)

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
    
    public int sqrt2(int x) {
        if (x < 0) return 0;
        if (x <=1) return x;
        int start = 1;
        int end = x/2+1;
        while (start <=end) {
            int mid = start + (end-start)/2;
            if (mid <= x/mid && mid+1 > x/(mid+1)) return mid;
            else if (mid < x/mid) {
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	Solution s= new Solution();
    	System.out.println(s.sqrt(2147395599));
    }
}