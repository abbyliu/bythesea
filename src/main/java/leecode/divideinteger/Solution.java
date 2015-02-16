package leecode.divideinteger;

/* Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * O(logQ)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.divide2(-2147483648, -1));
	}
	
	   public int divide2(int dividend, int divisor) {
	        if (divisor == 0) return Integer.MAX_VALUE;
	        if (dividend ==0) return 0;
	        if (divisor == 1) return dividend;
	        boolean negative = (dividend < 0) ^ (divisor < 0);
	        long v1 = Math.abs(dividend *1l);
	        long v2 = Math.abs(divisor * 1l);
	        long v = 0;
	        long fact = 1;

	        long v3 = v2;
	        while (v1 >= (v3<<1)) {
	            v3 = v3 << 1;
	            fact = fact << 1;
	        }

	        while ( v1 >=v2) {
	            v1 = v1 - v3;
	            v = v + fact;
	            while (v3 > v1) {
	                v3 = v3 >> 1;
	                fact = fact >> 1;
	            }
	        }        

	        if (negative) {
	            v = v * -1;
	        }
	        if (v <= Integer.MIN_VALUE) {
	            return Integer.MIN_VALUE;
	        } else if (v >= Integer.MAX_VALUE) {
	            return Integer.MAX_VALUE;
	        } else {
	            return (int)v;
	        }
	    }

	public int divide(int dividend, int divisor) {
		boolean positive = (dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0);
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (dividend == 0) return 0;
		
		
		long d1 = Math.abs(dividend * 1l);
		long d2 = Math.abs(divisor * 1l);
		if (d1 < d2) return 0;
		if (d2 == 1) {
			return (int)(positive? d1: -1 * d1);
		}
		int result = 0;
		int res = 0;
		while (d2 <= (d1>>1)) {
			d2 = d2 << 1;
			result++;
		}
		while (result >=0) {
			if (d1 >= d2) {
				d1 -= d2;
				res = res + (  1 << result);
			}
			d2 >>=  1;
			result--;
		}
		return positive? res: -1 * res;
	}
}
