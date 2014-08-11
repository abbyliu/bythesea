package leecode.zigzag;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convert(String s, int nRows) {
		if (nRows <= 1) // ZigZag needs at least two rows
			return s;
		int period = 2 * nRows - 2;
		int n = s.length();
		String result = "";
		// Scan each row
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < n; j += period) {
				result += s.charAt(j);
				// Possibly two characters in a period for all rows except the
				// top and bottom one
				// The second character is period-2*j apart from the first
				if (i > 0 && i < nRows - 1 && j + period - 2 * i < n)
					result += s.charAt(j + period - 2 * i);
			}
		}

		return result;
	}
}
