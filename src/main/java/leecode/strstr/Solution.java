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
        for (int i = 0; i <= haystack.length() - needle.length();i++) {
            if (match(haystack, i, needle)) {
                return haystack.substring(i);
            }
        }
        return null;
    }
    private boolean match(String s, int idx, String n) {
        for (int i = 0; i < n.length();i++) {
            if (s.charAt(i+idx) != n.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
