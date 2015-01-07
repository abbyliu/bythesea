package leecode.finddiffbits;

import java.util.Random;

public class FindBitDiff {
	
	
	public static void main(String[] args) {
		Random rd = new Random();
		long rd1 = rd.nextLong();
		long rd2 = rd.nextLong();
		long diff = rd1 ^ rd2;
		
		int count = 0;
		while (diff != 0) {
			if ((diff &1) !=0) {
				count++;
			}
			diff = diff >>> 1;
			System.out.println(diff);
		}
		
		System.out.println(rd1 + " diff from " + rd2 + " with "  + count + " bits");
		
		
		long rd3 = rd.nextLong();
		long rd4 = Math.abs(rd3);
		StringBuilder builder = new StringBuilder(String.valueOf(rd4));
		StringBuilder output = new StringBuilder();
		int idx = 0;
		while (idx < builder.length()) {
			int carry = 0;
			for (int j = idx; j < builder.length();j++) {
				char c = builder.charAt(j);
				int v = c - '0' + 10 * carry;
				int newValue = v/2;
				char newChar = (char)('0' + newValue);
				builder.setCharAt(j, newChar);
				carry = v % 2;
			}
			output.insert(0, carry);
			if (builder.charAt(idx) == '0') {
				idx++;
			}
		}
		System.out.println(rd4 + " to binary is");
		System.out.println(output.toString());

		int ff = 64 - output.length();
		StringBuilder b2 = new StringBuilder();
		for(int i = 0; i < ff; i++) {
			b2.append('1');
		}
		for (int i =0; i < output.length();i++) {
			if (output.charAt(i) == '1') {
				b2.append('0');
			} else {
				b2.append('1');
			}
		}
		
		int cr = 1;
		for (int i = b2.length()-1; i>=0; i--) {
			int v = b2.charAt(i) - '0' + cr;
			b2.setCharAt(i, (char)(v%2 + '0'));
			cr = v/2;
			if (cr == 0) {
				break;
			}
		}
		
		System.out.println((rd4 * -1) + " to binary is");
		System.out.println(b2.toString());
	}
	
	
	
}
