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
public class Solution {
	
	
	public List<List<String>> partition3(String s) {
	    List<List<String>> result = new ArrayList<>();
	    if (s == null || s.length() == 0) return result;
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    for (int i = 0; i < s.length();i++) {
	        dp[i][i] = true;
	    }
	    for (int i = 0; i < s.length();i++) {
	        for (int j = 0; j < i; j++) {
	            dp[j][i] = dp[j][i] 
	                     || (s.charAt(j) == s.charAt(i) && (i-j < 2||dp[j+1][i-1]));
	        }
	    }
	    
	    List<String> tmp = new ArrayList<>();
	    generatePair(dp, tmp, result, s, 0);
	    return result;
    }
    private void generatePair(boolean[][] dp, List<String> tmp, List<List<String>> result, String s, int idx) {
        if (idx == s.length()) {
            List<String> finals = new ArrayList<>(tmp);
            result.add(finals);
            return;
        }
        for (int i = idx ; i < s.length();i++) {
            if (dp[idx][i]) {
                tmp.add(s.substring(idx, i+1));
                generatePair(dp, tmp, result, s, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.partition2("bb");
	}
	public List<List<String>> partition2(String s) {
		if (s == null || s.length() < 1) return Collections.emptyList();
		int len = s.length();
		boolean[][] isDP = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isDP[i][i] = true;
		}
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < i ;j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (i-j < 2 || isDP[j+1][i-1])) {
					isDP[j][i] = true;
				}
			}
		}
		
		List<String> tmp = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
		findResult(isDP, s, 0, len, tmp,result);
		return result;
	}
    private void findResult(boolean[][] isDP, String s, int start, int len, List<String> tmp,
			List<List<String>> result) {
    	if (len<= 0) {
    		List<String> re = new ArrayList<>(tmp);
    		result.add(re);
    		return;
    	}
    	for (int ii = 0; ii < len; ii++) {
    		if (isDP[start][start+ii]) {
    			tmp.add(s.substring(start, start+ii+1));
    			findResult(isDP, s, start+ii+1, len - ii-1, tmp, result);
    			tmp.remove(tmp.size()-1);
    		}
    	}
		
	}
	public List<List<String>> partition(String s) {
    	if (s == null || s.length() < 1) {
    		List<List<String>> result = new ArrayList<>();
    		return result;
    	} 
    	
    	int len = s.length();
    	boolean[][] isP = new boolean[len][len];
    	
    	for (int i = len-1; i>=0; i--) {
    		for (int j = i; j < len ;j++) {
    			if (s.charAt(i) == s.charAt(j) && (j-i < 2 ||isP[i+1][j-1])) {
    				isP[i][j] = true;
    			}
    		}
    	}
    	
    	List<String> tmp = new ArrayList<>();
    	List<List<String>> result = new ArrayList<>();
    	generate(s, isP, 0, len ,tmp, result);
    	return result;
     }
    
    private void generate(String s, boolean[][] isP, int start, int len,
			List<String> tmp, List<List<String>> result) {
    	if (len <=0) {
    		List<String> finals = new ArrayList<>();
    		finals.addAll(tmp);
    		result.add(finals);
    	}
    	for (int i =0;i< len;i++) {
    		if (isP[start][start+i]) {
    			tmp.add(s.substring(start, start+i+1));
    			generate(s, isP, start+i+1, len-i-1, tmp, result);
    			tmp.remove(tmp.size()-1);
    		}
    	}
	}

}