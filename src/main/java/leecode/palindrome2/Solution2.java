package leecode.palindrome2;

/*
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */
public class Solution2 {
	public int minCut(String s) {
	    if (s == null || s.length() <=1) return 0;
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    for (int i = 0; i < s.length();i++) {
	        dp[i][i] = true;
	    }
	    for (int i = 0; i < s.length();i++) {
	        for (int j = 0; j < i;j++) {
	            if (s.charAt(i)==s.charAt(j) &&
	                (i-j<2 || dp[j+1][i-1])
	               ) {
	                dp[j][i] = true;
	            }
	        }
	    }
	    int[] cuts = new int[s.length()];
	    for (int i = 0; i < s.length();i++) {
	        cuts[i] = i;
	        if (dp[0][i]) {
	            cuts[i] =  0;
	        } else {
    	        for (int j = 1;j <= i;j++) {
    	            if (dp[j][i] && cuts[i] > cuts[j-1]+1) {
    	                cuts[i] = cuts[j-1]+1;
    	            }
    	        }
	        }
	    }
	    return cuts[s.length()-1];
	}
}