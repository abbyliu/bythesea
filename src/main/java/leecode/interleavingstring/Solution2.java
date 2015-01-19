package leecode.interleavingstring;
/* Interleaving String
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 

O(m*n), O(m) or O(n) after change
 */
public class Solution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length;i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        
        for (int i = 1; i < dp.length;i++) {
            for (int j = 1; j < dp[i].length;j++) {
                if (s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] | dp[i-1][j];
                }
                if (s2.charAt(j-1) == s3.charAt(i+j-1) ) {
                    dp[i][j] = dp[i][j]| dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
        
}