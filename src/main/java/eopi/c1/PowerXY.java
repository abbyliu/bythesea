package eopi.c1;

public class PowerXY {
	public double power(double x, int y) {
		double result = 1.0;
		long power = y;
		if (y<0) {
			y = -y; x = 1.0/x;
		}
		while (power >0) {
			if ((power&1) >0) {
				result*=x;
			}
			x = x*x; power >>=1;
		}
		return result;
	}
}
