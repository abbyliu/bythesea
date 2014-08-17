package eopi.c1;

public class GCD {
	public long gcd(long x, long y) {
		if (x == 0) {
			return y;
		}
		if (y==0) {
			return x;
		}
		if ( (x&1) == 0 && (y&1) ==0) {
			return gcd(x>>1, y>>1);
		} else if ( (x&1) == 0 && (y&1) !=0) {
			return gcd(x>>1, y);
		} else if ( (x&1) != 0 && (y&1) ==0) {
			return gcd(x, y>>1);
		} else if(x>y) {
			return gcd(x-y, y);
		} else {
			return gcd(x,y-x);
		}
	}
}
