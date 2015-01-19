package leecode.ladder1;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/* Word Ladder
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
		s.ladderLength("hot", "dog", dict);
	}

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null) {
            return 0;
        } else if (start.equals(end)) {
            return 1;
        }
        
        Deque<String> queue = new LinkedList<>();
        queue.offer(start);
        Deque<String> temp = new LinkedList<>();
        int dist = 1;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals(end)) {
                return dist;
            }
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                char old = s.charAt(i);
                for (char c = 'a'; c <='z'; c++) {
                    if (c != old) {
                        chars[i] = c;
                        String newString = new String(chars);
                        if (dict.contains(newString)) {
                            temp.add(newString);
                            dict.remove(newString);
                        }
                    }
                }
                chars[i] = old;
            }
            dict.remove(s);
            
            if (queue.isEmpty()) {
                queue = temp;
                temp = new LinkedList<>();
                dist++;
            }
        }
        
        return 0;
    }
}