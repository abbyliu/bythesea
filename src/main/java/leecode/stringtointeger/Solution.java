package leecode.stringtointeger;

/* String to Integer (atoi)

 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
 If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely
 (ie, no given input specs). You are responsible to gather all the input requirements up front.
 O(n) 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int atoi(String str) {
    	if (str== null) return 0;
    	String s = str.trim();
    	if (s.length() == 0) return 0;
    	
    	long v = 0;boolean negative = false;
    	boolean valid = true;
    	for (int i = 0; i < s.length() && valid; i++) {
    		char c = s.charAt(i);
    		switch(c) {
    		case '+': if (i != 0) { valid = false;} break;
    		case '-': if (i != 0) {valid = false;} else {negative = true;} break;
    		default:
    			int vv = c - '0';
    			if (vv > 9 || vv < 0) { valid = false; }
    			else {
    				v = v* 10 + vv;
    			}
    			break;
    		}
    	}
    	v = negative? v* -1l : v;
    	if (v >= Integer.MAX_VALUE) v = Integer.MAX_VALUE;
    	if (v <= Integer.MIN_VALUE) v = Integer.MIN_VALUE;
    	return (int)v;
    }
}
