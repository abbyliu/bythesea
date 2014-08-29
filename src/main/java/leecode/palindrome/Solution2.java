package leecode.palindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

 */
public class Solution2 {
	
	public List<List<String>> partition(String s) {
	    if (s == null || s.length() ==0) return Collections.emptyList();
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    for (int i = 0; i < s.length();i++) {
	        dp[i][i] = true;
	    }
	    for (int i = 0; i< s.length();i++) {
	        for (int j = 0; j< i;j++) {
	            if (s.charAt(i) == s.charAt(j)
	                && (i-j < 2 || dp[j+1][i-1])) {
	                dp[j][i] = true;
	            }
	        }
	    }
	    List<List<String>> ret = new ArrayList<>();
	    List<String> tmp = new ArrayList<>();
	    
	    findAll(dp, s, ret, tmp, 0);
	    return ret;
	}
	
	private void findAll(boolean[][] dp, String s, List<List<String>> ret,
	 List<String> tmp, int idx) {
	     if (idx == s.length()) {
	         List<String> rett = new ArrayList<>(tmp);
	         ret.add(rett);
	         return;
	     }
	     for (int i = idx; i < dp.length;i++) {
	         if (dp[idx][i]) {
	             String sub = s.substring(idx, i+1);
	             tmp.add(sub);
	             findAll(dp, s, ret, tmp, i+1);
	             tmp.remove(tmp.size()-1);
	         }
	     }
	 }
}