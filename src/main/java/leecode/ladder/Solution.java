package leecode.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Word Ladder II
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return

 O(nl) n- length of string, l - # of words in dict
 O(nl)
 */
public class Solution {
	static class Node {
		String v;
		Set<Node> adjs;

		Node(String s) {
			v = s;
			adjs = new HashSet<>();
		}

		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			for (Node n : adjs) {
				builder.append(n.v).append(",");
			}
			builder.append("]");
			return v + builder.toString();
		}
	}

	private Map<String, Set<String>> getGraph(String start, String end, Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> current = new HashSet<>();
        Set<String> next = new HashSet<>();
        current.add(end);
        Set<String> pre = null;
        
        boolean found = false;
        while (true) {
            for (String str: current) {
                if (str.equals(start)) {
                    found = true;
                    break;
                }    
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c<='z'; c++) {
                        if (old != c) {
                            chars[i] = c;
                            String newString = new String(chars);
                            if (dict.contains(newString)) {
                                if ((pre == null || !pre.contains(newString)) && !current.contains(newString)) {
                                    next.add(newString);
                                    if (graph.get(newString) == null) {
                                        Set<String> set = new HashSet<>();
                                        set.add(str);
                                        graph.put(newString, set);
                                    } else {
                                        graph.get(newString).add(str);
                                    }
                                }
                            }
                        }
                    }
                    chars[i] = old;
                }
            }
            
            pre = current;
            current = next;
            next = new HashSet<>();
            if (found || current.isEmpty()) {
                break;
            }
        }

        if (!found) {
            return Collections.emptyMap();
        }
        return graph;
 }
 
 public List<List<String>> findLadders(String start, String end, Set<String> dict) {
     if (start == null || end == null || dict.isEmpty()) {
         return Collections.emptyList();
     } else if (start.equals(end)) {
         List<String> list = new ArrayList<>();
         list.add(start);
         List<List<String>> output = new ArrayList<>();
         output.add(list);
         return output;
     }
     
     Map<String, Set<String>> graph = getGraph(start, end, dict);
     
     if (graph.isEmpty()) {
         return Collections.emptyList();
     }
     
     List<String> temp = new ArrayList<>();
     temp.add(start);
     List<List<String>> output = new ArrayList<>();
     findOutput(graph, start, temp, output);
     
     return output;
     
 }
 
 private void findOutput(Map<String, Set<String>> graph, String start, List<String> temp, List<List<String>> output) {
     if (!graph.containsKey(start)) {
         List<String> op = new ArrayList<>(temp);
         output.add(op);
         return;
     }
     Set<String> sets = graph.get(start);
     if (sets != null) {
         for (String str: sets) {
             temp.add(str);
             findOutput(graph, str, temp, output);
             temp.remove(temp.size()-1);
         }
     }
 }

}