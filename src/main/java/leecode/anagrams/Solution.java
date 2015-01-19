package leecode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Anagrams

 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

O(nklogk) , k = strs[i].length() average
*/
public class Solution {
    public List<String> anagrams(String[] strs) {
    	Map<String, List<String>> sets = new HashMap<>();
    	List<String> result = new ArrayList<>();
    	if (strs == null || strs.length <= 1) {
    		return result;
    	}
    	for (String s: strs) {
    		char[] chars = s.toCharArray();
    		Arrays.sort(chars);
    		String n = new String(chars);
    		if (sets.containsKey(n)) {
    			sets.get(n).add(s);
    		} else {
    			List<String> ans = new ArrayList<>();
    			ans.add(s);
        		sets.put(n, ans);
    		}
    	}
    	for (Map.Entry<String, List<String>> entry: sets.entrySet()) {
    		if (entry.getValue().size() > 1) {
    			result.addAll(entry.getValue());
    		}
    	}
    	return result;
    }
    
    

    public static void main(String[] args) {
    	Solution s =new Solution();
    	String[] strs = {"", ""};
    	s.anagrams(strs);
    }
}