package leecode.minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;
/*  Minimum Window Substring
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
		s.minWindow("a", "aa");
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