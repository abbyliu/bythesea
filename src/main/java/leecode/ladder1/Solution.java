package leecode.ladder1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

O(nl)
O(nl)
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		s.ladderLength2("hot", "dog", dict);
	}
	public int ladderLength2(String start, String end, Set<String> dict) {
		if (dict.size() ==0) return 0;
		Queue<String> wordq = new LinkedList<>();
		Queue<String> tmp = new LinkedList<>();
		int dis = 1;
		wordq.offer(start);
		
		while (!wordq.isEmpty()) {
			String s = wordq.poll();
			if (s.equals(end)) return dis;

			char[] chars = s.toCharArray();
			for (int i = 0; i < s.length(); i++) {
				for (char j= 'a';j <='z';j++) {
					if (j != chars[i]) {
						char old = chars[i];
						chars[i] = j;
						String s1= new String(chars);
						if (dict.contains(s1)) {
							tmp.offer(s1);
							dict.remove(s1);
						}
						chars[i] = old;
					}
				}
			}
			dict.remove(s);
			if (wordq.isEmpty()) {
				wordq = tmp;
				tmp = new LinkedList<>();
				dis++;
			}
		}
		return 0;
	}
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return 0;

		LinkedList<String> wordq = new LinkedList<String>();
		LinkedList<Integer> dq = new LinkedList<Integer>();

		wordq.add(start);
		dq.add(1);

		int result = 0;
		while (!wordq.isEmpty()) {
			String s = wordq.pop();
			Integer d = dq.pop();

			if (s.equals(end)) {
				result = d;
				break;
			}

			for (int i = 0; i < s.length(); i++) { //
				char[] arr = s.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					arr[i] = c;

					String test = new String(arr);
					if (dict.contains(test)) {
						wordq.add(test);
						dq.add(d + 1);
						dict.remove(test);
					}
				}
			}
		}

		return result;
	}

}