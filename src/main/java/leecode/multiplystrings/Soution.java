package leecode.multiplystrings;
/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
O(m*n)
 */
public class Soution {

	public String multiply2(String num1, String num2) {
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
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return null;
        String[] result = new String[num1.length() + num2.length()+1];
        for (int i = 0; i < result.length; i++) {
        	result[i] = "0";
        }
        String reverse1 = new StringBuilder(num1).reverse().toString();
        String reverse2 = new StringBuilder(num2).reverse().toString();
        for (int i = 0; i < num1.length(); i++) {
        	int digit1 = reverse1.charAt(i) - '0';
        	int carry = 0;
        	for (int j = 0; j < num2.length(); j++) {
        		int digit2 = reverse2.charAt(j) - '0';
        		int exist = result[i+j].charAt(0) - '0';
        		result[i+j] = (digit1 * digit2 + carry + exist)%10 + "";
        		carry = (digit1*digit2 + carry + exist)/10;
        	}
        	if (carry != 0) {
        		result[i + num2.length()] = carry + "";
        	}
        }
        boolean hitNoneZero = false;
        StringBuilder re= new StringBuilder();
        for (int i = result.length-1; i>=0; i--) {
        	int v = result[i].charAt(0) - '0';
        	if (v != 0) {
        		if (!hitNoneZero) {
        			hitNoneZero = true;
        		}
        		re.append(v);
        	} else if (hitNoneZero) {
        		re.append(v);
        	}
        }
        if (re.length() == 0) return "0";
        else return re.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 