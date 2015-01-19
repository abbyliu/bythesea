package leecode.validnumber;
/* Valid Number
 * Validate if a given string is numeric.
 * O(s.length())
 */
public class Solution {
	  public static void main(String[] args) {
		  Solution s = new Solution();
		  s.isNumber(" 005047e+6");
	  }
	  
    public boolean isNumber(String ss) {
    	if (ss == null) return false;
    	String a = ss.trim();
    	if (a.length() == 0) return false;
    	int idx = a.indexOf('e');
    	if (idx == 0) return false;
    	else if (idx == a.length()-1) return false;
    	else if (idx >0) {
    		int idx2 = (idx < a.length() -1)? a.indexOf('e', idx+1):-1;
    		if (idx2 >=0) return false;
    		return isRegularDecimal(a.substring(0, idx))
    				&& isInteger(a.substring(idx+1));
    	} else {
    		return isRegularDecimal(a);
    	}
    }
    
    
    private boolean isInteger(String substring) {
    	if (substring == null || substring.length() == 0) return false;
    	int firstDigloc = -1;
    	for (int i = 0; i < substring.length(); i++) {
    		char ch= substring.charAt(i);
    		if (ch == '+' || ch == '-') {
    			if (i != 0) return false;
    		} else if (!isDigit(ch)) {
    			return false;
    		} else {
    			firstDigloc = i;
    		}
    	}
    	return firstDigloc != -1;
	}


	private boolean isRegularDecimal(String s) {
    	if (s == null || s.length() == 0) return false;
    	int firstDigloc = -1;
    	int decLoc = -1;
    	for (int i = 0; i < s.length(); i++) {
    		char ch= s.charAt(i);
    		if (ch == '+' || ch == '-') {
    			if (i != 0) return false;
    		} else if (ch == '.') {
    			if (decLoc != -1) return false;
    			decLoc = i;
    		} else if (!isDigit(ch)) {
    			return false;
    		} else {
    			firstDigloc = i;
    		}
    	}
    	return firstDigloc != -1;
	}


	private boolean isDigit(char c) {
    	return c >= '0' && c<='9';
    }
}