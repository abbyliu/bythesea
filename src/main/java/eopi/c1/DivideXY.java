package eopi.c1;

public class DivideXY {
	public int divideXY(int x, int y) {
		int result = 0;
		while (x>=y) {
			int power = 1;
			while ((y<<power) >= (y<<(power-1))&&((y<<power) <=x)) {
				power++;
			}
			result+= (1<<(power-1));
			x -= (y<<(power-1));
		}
		return result;
	}
}
