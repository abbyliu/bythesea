package leecode.decodingways;

public class Solution2 {
    private boolean isValid(char c) {
        return c >='1' && c<='9';
    }
    private boolean isValid(char c1, char c2) {
        if (c1 == '1') {
            return c2 >='0' && c2 <='9';
        } else if (c1=='2') {
            return c2 >='0' && c2<='6';
        } else {
            return false;
        }
    }
    public int numDecodings(String s) {
        if (s == null || s.length()==0) return 0;
        int[] dp  = new int[s.length()+1];
        dp[0] = 1;
        char pre = s.charAt(0);
        dp[1] = isValid(pre)? 1:0;
        for (int i = 2;i < dp.length;i++) {
            char c = s.charAt(i-1);
            if (isValid(c)) {
                dp[i] += dp[i-1];
            }
            if (isValid(pre, c)) {
                dp[i] += dp[i-2];
            }
            pre = c;
        }
        return dp[s.length()];
    }
        
}