package eopi.c1;

public class ReverseBits {
    public static int[] precomputedReverse;
		public long reverseBits(long x) {
			int size = 16;
			int mask = 0xffff;
			return precomputedReverse[ (int)x & mask] << (3*size) |
					precomputedReverse[ (int)(x>>size) & mask] << (2*size) |
					precomputedReverse[ (int)(x>>size*2) & mask] << (size) |
					precomputedReverse[ (int)(x>>size*3) & mask] ; 
		}
}
