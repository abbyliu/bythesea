package leecode.distinctsubsequence;

public class Solution2{
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        int[][] dp = new int[S.length()+1][T.length()+1];
        for (int i = 0; i < dp.length;i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length;i++) {
            for (int j = 1; j < dp[i].length;j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
  
}