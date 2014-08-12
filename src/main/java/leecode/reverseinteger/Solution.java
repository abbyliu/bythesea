package leecode.reverseinteger;
/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
O(n) 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int reverse(int x) {
    	boolean negative = x < 0;
    	
    	long v = Math.abs(x);
    	
    	long ret = 0;
    	while (v > 0) {
    		int last = (int)( v % 10);
    		ret = ret * 10 + last;
    		v = v /10;
    	}
    	
    	if (negative) {
    		ret = ret * -1l;
    	}
    	if (ret > Integer.MAX_VALUE) {
    		ret = Integer.MAX_VALUE;
    	} else if (ret < Integer.MIN_VALUE) {
    		ret = Integer.MIN_VALUE;
    	}
    	return (int)ret;
    }
}
