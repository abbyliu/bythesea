package leecode.divideinteger;

/*
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
		s.divide(2147483647, 2);
	}
	
	public int divide3(int divident, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		if (divident == 0) return 0;
		boolean negative = (divident < 0)^ (divisor < 0);
		long v1 = Math.abs(divident*1l);
		long v2 = Math.abs(divisor*1l);
		
		long v = 0;
		while (v1 >= v2) {
			long vv = 1;
			long sub = v2;
			for (sub = v2; sub << 1 <= v1; ) {
				vv = vv << 1;
				sub = sub << 1;
			}
			v = v+ vv;
			v1 = v1 -sub;
		}
		
		return negative? (int) (-1l * v): (int)v;
	}
    public int divide2(int dividend, int divisor) {  
        if(divisor==0)  
            return Integer.MAX_VALUE;  
          
        int res = 0;  
        if(dividend==Integer.MIN_VALUE)  
        {  
            res = 1;  
            dividend += Math.abs(divisor);  
        }  
        if(divisor==Integer.MIN_VALUE)  
            return res;  
        boolean isNeg = ((dividend^divisor)>>>31==1)?true:false;  
        dividend = Math.abs(dividend);  
        divisor = Math.abs(divisor);  
        int digit = 0;  
        while(divisor<=(dividend>>1))  
        {  
            divisor <<= 1;  
            digit++;  
        }  
        while(digit>=0)  
        {  
            if(dividend>=divisor)  
            {  
                dividend -= divisor;  
                res += 1<<digit;  
            }  
            divisor >>= 1;  
            digit--;  
        }  
        return isNeg?-res:res;  
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
