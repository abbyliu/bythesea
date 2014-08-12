package leecode.nomantointeger;
/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
O(s.length())
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int romanToInt(String s) {
    	if (s == null || s.length() == 0) return 0;
    	int value = 0;
    	for (int i = s.length()-1;i>=0;) {
    		switch(s.charAt(i)) {
    		case 'I': value++;i--;break;
    		case 'V': value = value + 5; i--;
    				if (i >= 0 && s.charAt(i) == 'I') {
    					value = value -1; i--;
    				}
    				break;
    		case 'X': value = value + 10; i--;
    				 if ( i >= 0 && s.charAt(i) == 'I') {
    					 value = value -1;i--;
    				 }
    				 break;
    		case 'L': value = value + 50; i--;
    				if (i>=0 && s.charAt(i) == 'X') {
    					value = value - 10;i--;
    				}
    				break;
    		case 'C': value = value + 100; i--;
    				if ( i >= 0 && s.charAt(i) == 'X') {
    					value = value - 10; i--;
    				}
    				break;
    		case 'D': value = value + 500; i--;
    				if (i >= 0 && s.charAt(i) == 'C') {
    					value = value - 100; i--;
    				}
    				break;
    		case 'M': value = value + 1000;i--;
    				if (i >=0 && s.charAt(i) == 'C') {
    					value = value - 100; i--;
    				}
    				break;
    		}
    	}
    	return value;
    }
}
