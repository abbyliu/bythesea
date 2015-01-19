package leecode.decodingways;
/*  Decode Ways
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.
O(s.length()) , O(s.length()) 
 */
public class Solution {
	
    public int numDecodings(String s) {
    	if (s == null || s.length() <1) return 0;
    	
    	int[] ways = new int[s.length() +1];
    	ways[0] = 1;
    	String first = s.substring(0, 1);
    	
    	if (!isValid(first)) {
    		ways[1] = 0;
    		return 0;
    	} else {
    		ways[1] = 1;
    	}
    	for (int i = 2; i <= s.length(); i++) {
    		String v2 = s.substring(i-2, i);
    		String v1 = s.substring(i-1, i);
    		if (!isValid(v2)) {
    			if (isValid(v1)) {
    				ways[i] = ways[i-1];
    			} else {
    				ways[i] = 0;
    			}
    		} else {
    			if (isValid(v1)) {
    				ways[i] = ways[i-1] + ways[i-2];
    			} else {
    				ways[i] = ways[i-2];
    			}
    		}
    	}
    	return ways[s.length()];
    }
    
    private boolean isValid(String s) {
    	int v = Integer.parseInt(s);
    	if (v > 26 || v == 0) return false;
    	return s.equals(String.valueOf(v));
    }
}