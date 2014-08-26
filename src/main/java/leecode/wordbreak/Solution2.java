package leecode.wordbreak;

import java.util.Set;

public class Solution2 {
	
	public boolean wordBreak(String s, Set<String> dict) {
	    if (s == null || s.length() == 0 || dict == null || dict.isEmpty()) return false;
	    boolean[] dp = new boolean[s.length()+1];
	    for (int i = 0; i <= s.length();i++) {
	        String sub = s.substring(0, i);
	        if (dict.contains(sub)) {
	            dp[i] = true;
	            continue;
	        }
	        for (int j = 0; j < i;j++) {
	            sub = s.substring(j,i);
	            if (dp[j]&& dict.contains(sub)) {
	                dp[i] = true;
	                break;
	            }
	        }
	    }
	    return dp[s.length()];
	}
}