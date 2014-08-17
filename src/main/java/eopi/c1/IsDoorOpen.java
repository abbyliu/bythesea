package eopi.c1;

public class IsDoorOpen {
	public boolean isDoorOpen(int i) {
		double sqrt = Math.sqrt(i);
		int floor = (int)sqrt;
		return floor * floor == i;
	}
}
