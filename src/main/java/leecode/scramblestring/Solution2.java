package leecode.scramblestring;

import java.util.Arrays;

public class Solution2 {
	
	public boolean isScramble2(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length() ) return false;
		if (len == 0) {
			return true;
		}
		char[] c1= s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);Arrays.sort(c2);
		if (!new String(c1).equals(new String(c2))) {
			return false;
		}
		boolean[][][] dp = new boolean[s1.length()][s1.length()][s1.length()+1];
		for (int i = 0; i < s1.length(); i++) {
			for (int j =0; j < s1.length(); j++) {
				dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
			}
		}
		
		for (int k = 2; k <= len; k++) {
			for (int i = 0; i < len-k+1; i++) {
				for (int j =0; j < len-k+1;j++) {
					
					for (int l = 1; l < k ;l++) {
						dp[i][j][k]=((dp[i][j][l]&& dp[i+l][j+l][k-l])
							|| (dp[i+k-l][j][l]&& dp[i][j+l][k-l]));
						if (dp[i][j][k]) {
							break;
						}
					}
				}
			}
		}
		return dp[0][0][len];
	}
	   
	
	public boolean isScramble(String s1, String s2) {
		   int len = s1.length();
		   if (len != s2.length()) return false;
		   if (len == 0) {
			   return true;
		   }
		   char[] c1 = s1.toCharArray();
		   char[] c2 = s2.toCharArray();
		   boolean[][][] canT = new boolean[len][len][len];
		   for (int i = 0; i < len; i++)
			   for (int j = 0; j < len ; j++)
				   canT[0][i][j] = c1[i] == c2[j];
		   
		   for (int k = 2 ; k <=len ;k++) {
			   for (int i = len -k ;i>=0; i--) {
				   for (int j = len-k;j>=0;j--) {
					   boolean canTT = false;
					   for (int m = 1; m < k; m++) {
						   canTT =
								  (canT[m-1][i][j] && canT[k-m-1][i+m][j+m])
								  ||
								  (canT[m-1][i][j+k-m] && canT[k-m-1][i+m][j]);
						   if (canTT) {
							   break;
						   }
								  
					   }
					   canT[k-1][i][j] = canTT;
				   }
			   } 
		   }
		   
		   return canT[len-1][0][0];
	   }
}
