package leecode.multiplystrings;
/* Multiply Strings
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
O(m*n)
 */
public class Soution {

	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return null;
		int[] result = new int[num1.length() + num2.length()+1];
		char[] num1c = new StringBuilder(num1).reverse().toString().toCharArray();
		char[] num2c = new StringBuilder(num2).reverse().toString().toCharArray();
		
		for (int i = 0 ; i < num1c.length; i++) {
			int carry = 0;
			int v1 = num1c[i] - '0';
			int j = 0;
			for (j  = 0 ; j < num2c.length;j++) {
				int v2 = num2c[j] - '0';
				int value = v1 * v2 + carry + result[i+j];
				carry = value/10;
				result[i+j] = value %10;   
			}
			if (carry >0) {
				result[i+j] += carry;
			}
		}
		StringBuilder ret = new StringBuilder();
		boolean nonZero = false;
		for (int i = result.length-1; i>=0; i--) {
			if (result[i] != 0) {
				if (!nonZero) {
					nonZero = true;
				}
				ret.append(result[i]);
			} else if (nonZero || i == 0) {
				ret.append(0);
			}
		}
		return ret.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 