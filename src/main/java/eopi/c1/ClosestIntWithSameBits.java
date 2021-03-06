package eopi.c1;

public class ClosestIntWithSameBits {
	public long closetIntSameBits(long x) {
		for (int i = 0; i < 63; i++) {
			if ( (x >>i & 1) != (x >>(i+1) &1)) {
				x ^= (1<<i|i<<(i+1));
			}
		}
		return x;
	}
}
