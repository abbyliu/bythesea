package leecode.palindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*  Palindrome Partitioning
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

O(exponential)
 */
public class Solution {
	
	
	public List<List<String>> partition(String s) {
	    if (s == null || s.length() == 0) {
	        return Collections.emptyList();
	    }
	    
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    for (int i = 0; i < s.length(); i++) {
	        dp[i][i] = true;
	    }
	    
	    for (int i = 0; i < s.length(); i++ ) {
	        char charI = s.charAt(i);
	        for (int j = 0; j < i; j++) {
	            char charJ = s.charAt(j);
	            if (charI == charJ && ((i-j < 2) || dp[j+1][i-1])) {
	                dp[j][i] = true;
	            }
	        }
	    }
	    
	    List<List<String>> output = new ArrayList<>();
	    List<String> temp = new ArrayList<>();
	    
	    findAllSolution(dp, temp, output, 0, s);
	    return output;
	}
	
	private void findAllSolution(boolean[][] dp, List<String> temp, List<List<String>> output, int idx, String s)     {
	    if (idx == s.length()) {
	        List<String> solution = new ArrayList<>(temp);
	        output.add(solution);
	        return;
	    }
	    for (int i = idx ; i < s.length(); i++) {
	        if (dp[idx][i]) {
	            temp.add(s.substring(idx, i+1));
	            findAllSolution(dp, temp, output, i+1, s);
	            temp.remove(temp.size()-1);
	        }
	    }
	}
}