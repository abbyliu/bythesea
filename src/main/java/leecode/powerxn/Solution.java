package leecode.powerxn;
/*
 * Implement pow(x, n). 
 */
public class Solution {
	public double pow2(double  x, int n) {
	       if (x == 1) return x;
	        if ( x == 0) {
	        	if (n <=0)
	        		return Double.NaN;
	        	else return 0;
	        }
	        if ( n == 0) return 1;
	        if ( n < 0) {
	        	return 1.0/pow(x, (n+1) * -1)/x;
	        }
	        if (n == 1) {
	        	return x;
	        } else {
	        	int n1 = n/2;
	        	double v1 = pow(x*x, n1);
	        	if (n % 2 != 0) {
	        		return v1*x;
	        	} else {
	        		return v1;
	        	}
	        }		
	}
    public double pow(double x, int n) {
        if (x == 1) return x;
        if ( x == 0) {
        	if (n <=0)
        		return Double.NaN;
        	else return 0;
        }
        if ( n == 0) return 1;
        if ( n < 0) {
        	return 1.0/pow(x, (n+1) * -1)/x;
        }
        if (n == 1) {
        	return x;
        } else {
        	int n1 = n/2;
        	double v1 = pow(x, n1);
        	if (n % 2 != 0) {
        		return v1*v1*x;
        	} else {
        		return v1*v1;
        	}
        }
    }
}
