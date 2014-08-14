package eopi.c1;

public class Parity {
		public int parity(long x) {
			x ^= x>>32;
			x ^= x>>16;
			x ^= x>>8;
			x ^= x>>4;
			x &= 0xf;
			
			return fourBitParityLookup(x) & 1;
		}
		
		private static int FourBitParityTable = 0b0110100110010110;
		private int fourBitParityLookup(long x) {
			return (FourBitParityTable >> x);
		}
}
