package eopi.c1;

public class Reverse {
	public long reverse(int x) {
		boolean neg = x < 0;
		long result = 0;
		x = Math.abs(x);
		while ( x>0) {
			result += result * 10 + x%10;
			x = x/10;
		}
		return neg? -result:result;
	}
}
