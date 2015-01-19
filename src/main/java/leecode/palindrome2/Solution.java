package leecode.palindrome2;
/*  Palindrome Partitioning II
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
O(n2) 
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.minCut("dde");
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