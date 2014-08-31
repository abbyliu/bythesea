package leecode.scramblestring;

import java.util.Arrays;

public class Solution3 {
	public boolean isScramble(String s1, String s2) {
	    if (s1 == null && s2 == null) return true;
	    if (s1 == null || s2 == null) return false;
	    if (s1.length() != s2.length()) return false;
	    
	    char[] c1 =s1.toCharArray();
	    char[] c2 = s2.toCharArray();
	    Arrays.sort(c1);Arrays.sort(c2);
	    if (!new String(c1).equals(new String(c1))) {
	        return false;
	    }
	    
	    boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length()+1];
	    for (int i = 0; i < dp.length;i++) {
	        for(int j = 0; j < dp[i].length;j++) {
	            if (s1.charAt(i) == s2.charAt(j)) {
	                dp[i][j][1] = true;
	            }
	        }
	    }
	    for (int k = 2; k <=s1.length();k++) {
    	    for (int i = 0; i <= s1.length()-k;i++) {
    	        for (int j = 0; j <= s1.length()-k;j++) {
    	            for (int l = 1; l < k ; l++) {
    	                dp[i][j][k] = dp[i][j][k] ||
    	                   (dp[i][j][l] && dp[i+l][j+l][k-l]);
    	                dp[i][j][k] = dp[i][j][k] ||
    	                   (dp[i][j+k-l][l] && dp[i+l][j][k-l]);
    	            }
    	        }
    	    }
	    }
	    return dp[0][0][s1.length()];
	}
}