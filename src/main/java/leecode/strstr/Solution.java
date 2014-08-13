package leecode.strstr;
/*
 *  Implement strStr().

Returns a pointer to the first occurrence of 
needle in haystack, or null if needle is not part of haystack. 
O(N2)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String strStr(String haystack, String needle) {
    	if (haystack == null || needle == null) return null;
    	if (needle.length() == 0) return haystack;
    	
    	String s = haystack;
    	while (needle.length() <= s.length()) {
    		if (match(s, needle)) {
    			return s;
    		} else {
    			s = s.substring(1);
    		}
    	}
    	return null;
    }
	private boolean match(String s, String needle) {
		for (int i = 0; i < needle.length(); i++) {
			if (s.charAt(i) != needle.charAt(i) ) {
				return false;
			}
		}
		return true;
	}
}
