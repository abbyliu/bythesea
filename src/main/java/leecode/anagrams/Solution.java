package leecode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given an array of strings, return all groups of strings that are anagrams.

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
    
    
    public List<String> anagrams2(String[] strs) {
    	List<String> result = new ArrayList<>();
    	if (strs == null || strs.length <=1) return result;
    	
    	Map<String, List<String>> map = new HashMap<>();
    	for (String s : strs) {
    		char[] chars= s.toCharArray();
    		Arrays.sort(chars);
    		String sorted = new String(chars);
    		if (map.containsKey(sorted)) {
    			map.get(sorted).add(s);
    		} else {
    			List<String> newList = new ArrayList<>();
    			newList.add(s);
    			map.put(sorted, newList);
    		}
    	}
    	for (Map.Entry<String, List<String>> entry: map.entrySet()) {
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