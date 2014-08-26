package leecode.wordbreak2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.isEmpty()) return Collections.emptyList();
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
	    if (!dp[s.length()]) {
	        return Collections.emptyList();
	    }

        List<String> ret = new ArrayList<>();
        String tmp = "";
        findAllStrings(ret, dp, tmp, 0,s, dict);
        return ret;
    }
    private void findAllStrings(List<String> ret, boolean[] dp, String tmp, int idx, String s, Set<String> dict) {
        if (idx == s.length()) {
            ret.add(tmp);
            return;
        }
        for (int i = idx; i < dp.length;i++) {
            if (dp[i]) {
                String sub = s.substring(idx, i);
                if (dict.contains(sub)) {
                    String newS = null;
                    if (tmp.length()==0) {
                        newS = sub;
                    } else {
                        newS = tmp + " " + sub;
                    }
                    findAllStrings(ret, dp, newS, i, s, dict);
                }
            }
           
        }
    }
 
    public static void main(String[] args) {
    	Solution2 s = new Solution2();
    	Set<String> dict = new HashSet<>();
    	dict.add("a");dict.add("b");
    	s.wordBreak("ab", dict);
    }
}