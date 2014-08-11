package leecode.distinctsubsequence;

/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

O(S.length()*T.length()), O(S.length()*T.length()) or O(S.length())
 */
public class Solution {
	public int numDistinct2(String S, String T) {
		if (S == null || T == null) return 0;
		int m = T.length();
		int n = S.length();
		if (m > n) return 0;
		int[][] ways = new int[n+1][m+1];
		for (int i = 0; i <= n;i++) {
			ways[i][0] = 1;
		}
		
		for (int i = 1 ; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (S.charAt(i-1) == T.charAt(j-1)) {
					ways[i][j] = ways[i-1][j-1] + ways[i-1][j];
				} else {
					ways[i][j] = ways[i-1][j];
				}
			}
		}
		return ways[n][m];
	}
    public int numDistinct(String S, String T) {
    	int m = T.length();
    	int n = S.length();
    	if (m > n ) return 0;
    	int[] path = new int[m+1];
    	path[0] = 1;
    	for (int j = 1;j <= n ;j++) {
    		for (int i = m; i>=1;i--) {
    			path[i] = path[i] + (T.charAt(i-1) == S.charAt(j-1)? path[i-1]:0 );
    		}
    	}
    	return path[m];
    }
}
