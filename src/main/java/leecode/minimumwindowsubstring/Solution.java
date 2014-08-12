package leecode.minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;
/*
 *  Given a string S and a string T, find the minimum window in S which will contain all 
 *  the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 

O(n)
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.minWIndow2("a", "aa");
	}
	public String minWIndow2(String s, String t) {
		if (s == null || s.length() == 0 || t== null|| t.length() == 0) return "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		int minStart = -1;
		int minEnd = s.length()-1;
		int minLength = s.length();
		int end = 0;
		int begin = 0;
		int m = t.length();
		int match = 0;
		for (end= 0; end < s.length();end++) {
			char c = s.charAt(end);
			if (!map.containsKey(c)) {
				continue;
			} 
			map.put(c, map.get(c)-1);
			if (map.get(c)>=0) {
				match++;
			}
			while (match == m) {
				char cc = s.charAt(begin);
				while (!map.containsKey(cc)) {
					begin++;
					cc = s.charAt(begin);
				}
				map.put(cc, map.get(cc)+1);
				if (map.get(cc) >0) {
					if (end - begin < minLength) {
						minStart = begin;
						minEnd = end;
						minLength = minEnd - minStart;
					}
					match--;
				}
				begin++;
			}
		}
		if (minStart == -1) {
			return "";
		} else {
			return s.substring(minStart, minEnd+1);
		}
	}
	
	public String minWindow(String S, String T) {
		if (S == null || T == null || S.length() == 0 || T.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			char c= T.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else
				map.put(c, 1);
		}
		int count = 0;
		int pre = 0;
		String res = "";
		int minLen = S.length() + 1;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) >= 0)
					count++;
				while (count == T.length()) {
					char prec = S.charAt(pre);
					if (map.containsKey(prec)) {
						map.put(prec, map.get(prec) + 1);
						if (map.get(prec) > 0) {
							if (minLen > i - pre + 1) {
								res = S.substring(pre, i + 1);
								minLen = i - pre + 1;
							}
							count--;
						}
					}
					pre++;
				}
			}
		}
		return res;
	}
}