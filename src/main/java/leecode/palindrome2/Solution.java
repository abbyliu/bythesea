package leecode.palindrome2;
/*
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.minCut3("dde");
	}
	public int minCut3(String s) {
        if (s == null || s.length()  <=1) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length();i++) {
            dp[i][i] = true;
        }
        int[] cuts = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[j][i] = dp[j][i] ||
                 
                   (s.charAt(j)== s.charAt(i) &&
                      (i-j< 2 || dp[j+1][i-1]));
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
        	cuts[i] = i;
        	for (int j = 0; j < i; j++) {
        		if (dp[0][i]) {
        			cuts[i] = 0;
        			break;
        		} else {
        			if (dp[j+1][i]) {
        				if (cuts[j] +1 < cuts[i]) {
        					cuts[i] = cuts[j]+1;
        				}
        			}
        		}
        	}
        }
        return cuts[s.length()-1];
	}
	
	public int minCut2(String s) {
		if (s == null || s.length() <=1) return 0;
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		int cut[] = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
			for (int j = 0; j < i;j++) {
				if (s.charAt(i) == s.charAt(j) &&
						(i-j < 2|| dp[j+1][i-1])) {
					dp[j][i] = true;
				}
				
			}
		}

		for (int i = s.length()-1; i>=0;i--) {
			cut[i] = s.length()-1-i;
			for (int j = s.length()-1; j>=i;j--) {
				if (dp[i][j]) {
					if ( j == s.length()-1) {
						cut[i] = 0;
					} else {
						if ( cut[j+1]+1 < cut[i]) {
							cut[i] = cut[j+1]+1;
						}
					}
				}
			}
		}
		return cut[0];
	}
    public int minCut(String s) {
    	if (s == null || s.length() <= 1) {
    		return 0;
    	} 
    	
    	int len = s.length();
    	boolean[][] isP = new boolean[len][len];
    	int[] cuts = new int[len];
    	
    	for (int i = len-1; i>=0; i--) {
    		cuts[i] = len - 1 - i;
    		for (int j = i; j < len ;j++) {
    			if (s.charAt(i) == s.charAt(j) && (j-i < 2 ||isP[i+1][j-1])) {
    				isP[i][j] = true;
    				if (j == len-1) {
    					cuts[i] = 0;
    				} else if (cuts[j+1]+1 < cuts[i]) {
    					cuts[i] = cuts[j+1] + 1;
    				}
    			}
    		}
    	}
    	return cuts[0];
    }
}