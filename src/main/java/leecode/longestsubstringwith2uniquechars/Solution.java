package leecode.longestsubstringwith2uniquechars;

import java.util.HashMap;
import java.util.Map;
/* Longest Substring with At Most Two Distinct Characters */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0;
        int j = -1;
        int maxLen = 0;
        
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) {
            	continue;
            }
            
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - 1 - i + 1, maxLen);
                i = j + 1; 
            }
            j = k - 1;  
        }
        return Math.max(s.length() - -1 - i + 1, maxLen);
    }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {  
        int start = 0;  
        int maxLen = 0;  
      
        // Key: letter; value: the number of occurrences.  
        Map<Character, Integer> map = new HashMap<Character, Integer>();  
        int i;  
        for (i = 0; i < s.length(); ++i) {  
            char c = s.charAt(i);  
            if (map.containsKey(c)) {  
                map.put(c, map.get(c) + 1);  
            } else {  
                map.put(c, 1);  
                while (map.size() > k) {  
                    char startChar = s.charAt(start++);  
                    int count = map.get(startChar);  
                    if (count > 1) {  
                        map.put(startChar, count - 1);  
                    } else {  
                        map.remove(startChar);  
                    }  
                }  
            }  
      
            maxLen = Math.max(maxLen, i - start + 1);  
        }  
      
        return maxLen;  
    }  
}
