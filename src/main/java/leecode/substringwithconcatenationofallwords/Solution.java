package leecode.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] L = { "foo", "bar" };
		s.findSubstring2("barfoothefoobarman", L);
	}

	public ArrayList<Integer> findSubstring3(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || L == null || S.length() == 0 || L.length == 0)
			return result;
		int n = S.length(), m = L.length, l = L[0].length();
		// Use a HashMap for word counting in L
		HashMap<String, Integer> expected = new HashMap<String, Integer>();
		for (int i = 0; i < m; i++) {
			if (expected.containsKey(L[i])) // Duplicate string
				expected.put(L[i], expected.get(L[i]) + 1);
			else
				// New string
				expected.put(L[i], 1);
		}
		// For each i, we work on S[i..i+l-1], S[i+l..i+2l-1], ...
		for (int i = 0; i < l; i++) {
			HashMap<String, Integer> actual = new HashMap<String, Integer>();
			int count = 0; // The number of consecutive matches
			int windowLeft = i; // The index of the left of the sliding window
			// For each j, we work on S[j..j+l-1]
			for (int j = i; j <= n - l; j += l) {
				String current = S.substring(j, j + l); // S[j..j+1-1]
				if (expected.containsKey(current)) { // A valid string in L
					// Update the word counting and the number of matches within
					// the window
					count++;
					if (actual.containsKey(current))
						actual.put(current, actual.get(current) + 1);
					else
						actual.put(current, 1);
					// If there is more appearance of "current" than expected
					if (actual.get(current) > expected.get(current)) {
						// Take out all words before its first appearance
						// (inclusive)
						// within the window
						String temp;
						do {
							temp = S.substring(windowLeft, windowLeft + l);
							actual.put(temp, actual.get(temp) - 1);
							count--;
							windowLeft += l;
						} while (!temp.equals(current));
					}
					// Each word appears exactly once within the window;
					// a substring that meets the requirements has been found
					if (count == m) {
						result.add(windowLeft);
						// Take out the first word within the window
						String temp = S.substring(windowLeft, windowLeft + l);
						actual.put(temp, actual.get(temp) - 1);
						count--;
						windowLeft += l;
					}
				} else { // An invalid string in L
					// Start a new window at j+l
					actual.clear();
					count = 0;
					windowLeft = j + l;
				}
			}
		}

		return result;
	}

	public List<Integer> findSubstring2(String S, String[] L) {
		List<Integer> result = new ArrayList<>();
		if (L == null || L.length == 0)
			return result;
		int[] counts = new int[S.length()];
		Map<String, Integer> dicts = new HashMap<>();
		for (String l : L) {
			if (dicts.containsKey(l)) {
				dicts.put(l, dicts.get(l) + 1);
			} else {
				dicts.put(l, 1);
			}
		}
		int len = L[0].length();
		for (int i = S.length() - len; i >= 0; i--) {
			String s = S.substring(i, i + len);
			if (dicts.containsKey(s)) {
				if (i + len == S.length()) {
					counts[i] = 1;
				} else {
					counts[i] = 1 + counts[i + len];
				}
			}
		}

		for (int i = 0; i < counts.length; i++) {
			if (counts[i] < L.length) {
				continue;
			}
			Map<String, Integer> dictcopy = new HashMap<>(dicts);
			for (int j = 0; j < L.length; j++) {
				String s = S.substring(i + j * len, i + (j + 1) * len);
				if (dictcopy.containsKey(s)) {
					int v = dictcopy.get(s);
					v--;
					if (v == 0) {
						dictcopy.remove(s);
					} else {
						dictcopy.put(s, v);
					}
				} else {
					break;
				}
			}
			if (dictcopy.isEmpty()) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new ArrayList<>();
		if (L == null || L.length == 0)
			return result;
		int idx = 0;
		int totalLength = L[0].length() * L.length;
		Map<String, Integer> map = new HashMap<>();
		for (String s : L) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		while (idx < S.length()) {
			if (idx + totalLength > S.length())
				break;
			String ss = S.substring(idx, idx + totalLength);
			Map<String, Integer> set = new HashMap<>(map);
			for (int i = 0; i < L.length; i++) {
				String s = ss.substring(L[0].length() * i, L[0].length()
						* (i + 1));
				if (!set.containsKey(s)) {
					break;
				} else {
					int v = set.get(s) - 1;
					if (v == 0) {
						set.remove(s);
					} else {
						set.put(s, v);
					}
				}
			}
			if (set.size() == 0) {
				result.add(idx);
			}
			idx++;
		}
		return result;
	}
}
