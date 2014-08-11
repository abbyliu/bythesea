package leecode.longestpalindromicsubstring;
/*
 * Given a string S, find the longest palindromic substring in S.
 *  You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *  O(n2), but O(n) is possible via suffix tree
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestPalindrome3(String s) {
		if (s == null || s.length()==0) return s;
		boolean isP[][] = new boolean[s.length()][s.length()];
		int max = 1;
		String maxStr = s.substring(0,1);
		for (int i = 0; i < s.length();i++) {
			for (int j = 0; j < i ;j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (i-j <=1 || isP[j+1][i-1])) {
					isP[j][i]= true;
					if (i-j+1 >max) {
						maxStr = s.substring(j, i+1);
						max = i-j+1;
					}
				}
			}
			isP[i][i]= true;
		}
		return maxStr;
	}
	public String longestPalindrome2(String s) {
		if (s == null || s.length() == 0) return s;
		String ret = s.substring(0,1);
		
		for (int i = 0 ;i < s.length()-1; i++) {
			String s1 = expand(s, i,i);
			if (s1.length() > ret.length()) {
				ret = s1;
			}
			
			String s2 = expand(s, i,i+1);
			if (s2.length() > ret.length()) {
				ret = s2;
			}
		}
		
		return ret;
	}
	
    private String expand(String s, int i, int j) {
    	int ii = i;
    	int jj = j;
    	
    	while (ii>=0 && jj<= s.length()-1&& s.charAt(ii) == s.charAt(jj)) {
    		ii--;
    		jj++;
    	}
    	
		return s.substring(ii+1,jj); 
	}

	public String longestPalindrome(String s) {
    	if (s == null || s.length() <=1) return s;
    	boolean match[][] = new boolean[s.length()][s.length()];
    	match[0][0] = true;
    	int start = 0;
    	int end = 1;
    	int max = 1;
    	for (int i = 0; i < s.length();i++) {
    		for (int j = 0; j < i ; j++) {
    			match[j][i] = (s.charAt(j) == s.charAt(i) && (i-j < 2 || match[j+1][i-1]));
    			if (match[j][i] && i-j+1 > max) {
    				max = i - j + 1;
    				start = j; 
    				end = i;
    			}
    		}
    		match[i][i] = true;
    	}
    	return s.substring(start, end+1);
    }
    
}
