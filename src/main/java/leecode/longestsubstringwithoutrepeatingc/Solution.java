package leecode.longestsubstringwithoutrepeatingc;

import java.util.HashMap;
import java.util.Map;
/* Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for
 *  "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *  O(n)
 *  O(n)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int lengthOfLongestSubstring2(String s) {
    	if (s == null || s.length() ==0) return 0;
    	if (s.length() == 1) return 1;
    	int start = 0;
    	int max = 1;
    	Map<Character, Integer> map = new HashMap<>();
    	for (int i = 0; i < s.length();i++) {
    	    char c = s.charAt(i);
    	    if (map.containsKey(c)) {
    	       int preI = map.get(c);
    	       if (preI >= start)  {
    	           start = preI+1;
    	       }
    	    }
    	    map.put(c, i);
    	    max = Math.max(max, i-start+1);
    	}
    	return max;
    }
	
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int count = 1;
        Map<Character, Integer> pos = new HashMap<>();
        pos.put(s.charAt(0), 0);
        int position = 0;
        int idx = 1;
        while (idx < s.length()) {
        	char c = s.charAt(idx);
        	if (!pos.containsKey(c)) {
        		pos.put(c,  idx);
        	} else {
        		int last = pos.get(c);
        		if (last >= position) {
        			position = last+1;
        		} 
    			pos.put(c, idx);
        	}
    		count = Math.max(count, idx - position+1);
        	idx++;
        }
        return count;
    }
}
