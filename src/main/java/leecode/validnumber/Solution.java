package leecode.validnumber;
/*
 * Validate if a given string is numeric.
 * O(s.length())
 */
public class Solution {
	  public static void main(String[] args) {
		  Solution s = new Solution();
		  s.isNumber2(" 005047e+6");
	  }
	   public boolean isNumber2(String s) {
	        if (s == null || s.trim().length() == 0) return false;
	        s = s.trim();
	        int idx = s.indexOf("e");
	        if (idx< 0) {
	            return isDecimal(s);
	        } else {
	            return isDecimal(s.substring(0,idx))
	                     && isInteger2(s.substring(idx+1));
	        }
	    }
	    
	    private boolean isDecimal(String s) {
	        if (s.length() ==0) return false;
	        boolean hasDecimal = false;
	        boolean hasDigits = false;
	        for (int i = 0; i < s.length();i++) {
	            char ch = s.charAt(i);
	            switch(ch) {
	                case '+': if (i !=0) return false;break;
	                case '-': if (i!= 0) return false;break;
	                case '.': if (!hasDecimal) {
	                             hasDecimal = true;
	                             break;
	                          } else {
	                              return false;
	                          }
	                case '0':
	                case '1':
	                    case '2':
	                        case '3':
	                            case '4':
	                                case '5':
	                                    case '6':
	                                        case '7':
	                                            case '8':
	                                                case '9':
	                                                    hasDigits = true; break;
	                default: return false;
	            }
	        }
	        return hasDigits;
	    }
	    private boolean isInteger2(String s) {
	        if (s.length() ==0) return false;
	        for (int i = 0; i < s.length();i ++) {
	            char c = s.charAt(i);
	            if (c == '+' && i!=0) return false;
	            if (c == '-' && i!=0) return false;
	            if (c <'0' || c>'9') return false;
	        }
	        return true;
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