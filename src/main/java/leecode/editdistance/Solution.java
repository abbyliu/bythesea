package leecode.editdistance;
/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
O(m*n), O(m*n) can be reduced to O(m) or O(n)
 */
public class Solution {
	
	public int minDistance3(String word1, String word2) {
		if (word1 == null && word2 == null) return 0;
		if (word1 == null) return word2.length();
		if (word2 == null) return word1.length();
		int[][] dis = new int[word1.length()+1][word2.length()+1];
		for (int i = 0; i <= word1.length(); i++) {
			dis[i][0] = i;
		}
		for (int j= 0; j <= word2.length();j++) {
			dis[0][j] = j;
		}
		 for(int i = 1;i <= word1.length(); i++ ) {
			 for (int j = 1;j <= word2.length(); j++) {
				 char c1 = word1.charAt(i-1);
				 char c2 = word2.charAt(j-1);
				 if (c1 == c2) {
					 dis[i][j] = Math.min(dis[i-1][j-1], Math.min(dis[i][j-1]+1, dis[i-1][j]+1));
				 } else {
					 dis[i][j] = Math.min(dis[i-1][j-1]+1, Math.min(dis[i][j-1]+1, dis[i-1][j]+1));
				 }
			 }
		 }
		
		return dis[word1.length()][word2.length()];
		
	}
    public int minDistance(String word1, String word2) {
    	if (word1 == null && word2 == null) return 0;
    	int[][] dp = new int[word1.length()+1][word2.length()+1];
    	for (int j = 0; j < dp[0].length;j++) {
    		dp[0][j] = j;
    	}
    	for (int i = 0; i < dp.length;i++) {
    		dp[i][0] = i;
    	}
    	for (int i = 1; i <= word1.length(); i++) {
    		for (int j = 1; j <= word2.length();j++) {
    			char ch1 = word1.charAt(i-1);
    			char ch2 = word2.charAt(j-1);
    			if ( ch1 == ch2) {
    				dp[i][j] = dp[i-1][j-1];
    			} else {
    				int v1 = dp[i-1][j] + 1;
    				int v2 = dp[i][j-1] + 1;
    				int v3 = dp[i-1][j-1] + 1;
    				dp[i][j] = Math.min(v1, Math.min(v2, v3));
    			}
    		}
    	}
    	return dp[word1.length()][word2.length()];
    }
    
    public int minDistance2(String word1, String word2) {
    	if (word1 == null && word2 == null) return 0;
    	int[] dp = new int[word2.length()+1];
    	for (int j = 0; j < dp.length;j++) {
    		dp[j] = j;
    	}
    	int[] tmp = new int[word2.length()+1];
    	for (int i = 1; i <= word1.length(); i++) {
    		tmp[0]= i;
    		for (int j = 1; j <= word2.length();j++) {
    			char ch1 = word1.charAt(i-1);
    			char ch2 = word2.charAt(j-1);
    			if ( ch1 == ch2) {
    				tmp[j] = dp[j-1];
    			} else {
    				int v1 = dp[j] + 1;
    				int v2 = tmp[j-1] + 1;
    				int v3 = dp[j-1] + 1;
    				tmp[j] = Math.min(v1, Math.min(v2, v3));
    			}
    		}
    		int[] sw = dp;
    		dp = tmp;
    		tmp = sw;
    		
    	}
    	return dp[word2.length()];
    }
}