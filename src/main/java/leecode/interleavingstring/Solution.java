package leecode.interleavingstring;
/*
 * iven s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 

O(m*n), O(m) or O(n) after change
 */
public class Solution {
	public boolean isInterleave2(String s1, String s2, String s3) {
		if (s1 == null && s2 == null) {
			if (s3 == null) return true;
			else return false;
		}
		if (s1== null && !s2.equals(s3)) return false;
		if (s2 == null && !s1.equals(s3)) return false;
		if (s1.length() + s2.length() != s3.length()) return false;
		
		boolean[][] is = new boolean[s1.length()+1][s2.length()+1];
		is[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			is[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && is[i-1][0];
		}
		
		for (int j = 1; j <= s2.length(); j++) {
			is[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && is[0][j-1];
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length();j++) {
				is[i][j] = is[i][j] || (s1.charAt(i-1) == s3.charAt(i+j-1) && is[i-1][j]);
				is[i][j] = is[i][j] || (s2.charAt(j-1) == s3.charAt(i+j-1) && is[i][j-1]);
			}
		}
		return is[s1.length()][s2.length()];
	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] flags = new boolean[s1.length()+1][s2.length()+1];
        flags[0][0]= true;
        for (int i = 1; i <= s1.length();i++) {
        	char c1 = s1.charAt(i-1);
        	char c2 = s3.charAt(i-1);
        	if (c1 == c2) {
        		flags[i][0] = true;
        	} else {
        		break;
        	}
        }
        for (int j = 1;j <= s2.length(); j++) {
        	char c2 = s2.charAt(j-1);
        	char c3 = s3.charAt(j-1);
        	if (c2 == c3) {
        		flags[0][j] = true;
        	} else {
        		break;
        	}
        }
        for (int i = 1; i <= s1.length();i++) {
        	char c1 = s1.charAt(i-1);
        	for (int j = 1;j <= s2.length(); j++) {
        		char c2 = s2.charAt(j-1);
        		int i3 = i+j;
        		char c3 = s3.charAt(i3-1);
        		if (c1 == c3) {
        			flags[i][j] = flags[i-1][j]||flags[i][j];
        		}
        		if (c2 == c3) {
        			flags[i][j] = flags[i][j-1] || flags[i][j];
        		}
        	}
        }
        return flags[s1.length()][s2.length()];
    }
}