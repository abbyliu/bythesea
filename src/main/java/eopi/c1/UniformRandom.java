package eopi.c1;

import java.util.Random;

public class UniformRandom {
	public int uniformRandom(int a, int b) {
		int t = b-a+1;
		int res;
		do {
			res = 0;
			for (int i = 0; (1<<i) < t; i++) {
				res = res*2 + zeroOneRandom();
			}
		} while ( res >=t) ;
		return res;
	}
	private int zeroOneRandom() {
		return new Random().nextInt(1);
	}	
}
