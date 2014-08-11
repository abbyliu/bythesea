package leecode.ladder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		Set<String> dict = new HashSet<>();
		dict.add("a");dict.add("b");dict.add("c");
		s.findLadders2("a", "c", dict);
	}
    public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (start == null || end == null || dict.isEmpty())  return result;
        if (!dict.contains(start)|| !dict.contains(end)) return result;
        if (start.equals(end)) {
            List<String> tmp = new ArrayList<>();
            tmp.add(start);
            result.add(tmp);
            return result;
        }
        Map<String, Set<String>> graph = buildGraph2(start,end, dict);
        if (!graph.isEmpty()) {
            List<String> tmp = new ArrayList<>();
            buildResult(graph, start, tmp, result);
        }
        return result;
   }
   private void buildResult(Map<String, Set<String>> graph, String start, List<String> tmp, List<List<String>> result) {
       List<String> copy = new ArrayList<>(tmp);
       copy.add(start);
       if (!graph.containsKey(start)) {
           result.add(copy);
           return;
       }
       for (String s: graph.get(start)) {
           buildResult(graph, s, copy, result);
       }
       
   }
   private Map<String, Set<String>> buildGraph2(String start, String end, Set<String> dict) {
       Set<String> previous = null;
       Set<String> current = new HashSet<>();
       Set<String> next = new HashSet<>();
       current.add(end);
       Map<String, Set<String>> graph = new HashMap<>();
       boolean found = false;
       while (!found) {
           for (String s: current) {
               if (s.equals(start)) {
                   found = true;
                   break;
               }
               char[] chars = s.toCharArray();
               for (int i = 0; i < s.length(); i++) {
                   for (char c = 'a'; c<='z';c++) {
                       if (chars[i] != c) {
                           char back = chars[i];
                           chars[i] = c;
                           String newStr = new String(chars);
                           if (dict.contains(newStr)
                                && !current.contains(newStr)
                                &&(previous == null || !previous.contains(newStr))) {
                               next.add(newStr);
                               if (graph.containsKey(newStr)) {
                                   graph.get(newStr).add(s);
                               } else {
                                   Set<String> set = new HashSet<>();
                                   set.add(s);
                                   graph.put(newStr, set);
                               }
                           }
                           chars[i] = back;
                       }
                   }
               }
           }
           if (next.isEmpty()) {
               break;
           } else {
               previous = current;
               current = next;
               next = new HashSet<>();
           }
       }
       if (found) {
           current.clear();
           current.add(start);
       } else {
           graph.clear();
       }
       return graph;
   }
	
	
	private HashMap<String, HashSet<String>> buildGraph(String source,
			String sink, HashSet<String> dict) {
		HashMap<String, HashSet<String>> parents = new HashMap<>();

		// in BFS, when testing if a node can be added to the new
		// level we only need to test if it has been visited in the
		// previous two levels.
		HashSet<String> previousLevel = null;
		HashSet<String> currentLevel = new HashSet<>();
		currentLevel.add(source);

		// creating levels using BFS
		boolean reachedEnd = false;
		while (!reachedEnd) {
			HashSet<String> newLevel = new HashSet<>();
			// search for unvisited neighbors of each word in the current level
			for (String word : currentLevel) {
				for (int i = 0; i < word.length(); ++i) {
					char[] chars = word.toCharArray();
					for (chars[i] = 'a'; chars[i] <= 'z'; ++chars[i]) {
						if (chars[i] == word.charAt(i)) {
							continue;
						}

						// create a new word by changing exactly one letter
						String newWord = new String(chars);
						if (!dict.contains(newWord)
								|| currentLevel.contains(newWord)
								|| previousLevel != null
								&& previousLevel.contains(newWord)) {
							continue;
						}

						// even if we found `sink', we don't "break": we need
						// to find all parents of `sink'.
						if (newWord.equals(sink)) {
							reachedEnd = true;
						}

						newLevel.add(newWord);
						if (!parents.containsKey(newWord)) {
							parents.put(newWord, new HashSet<String>());
						}
						parents.get(newWord).add(word);
					}
				}
			}
			if (newLevel.isEmpty()) {
				break;
			}

			previousLevel = currentLevel;
			currentLevel = newLevel;
		}
		if (reachedEnd) {
			// if we reached `sink', delete all other words in the last level.
			currentLevel.clear();
			currentLevel.add(sink);
		} else {
			// if we can't reach `sink', return an empty graph
			parents.clear();
		}
		return parents;
	}

	// end{build-graph}

	// begin{generate-paths}
	/**
	 * Use DFS to recursively generate all backward paths of words. We assume
	 * that: - partialPath is valid - it is valid to append nextWord to
	 * partialPath
	 */
	private void generatePaths(ArrayList<String> partialPath, String nextWord,
			HashMap<String, HashSet<String>> parents,
			ArrayList<ArrayList<String>> paths) {
		ArrayList<String> extendedPath = new ArrayList<>(partialPath);
		extendedPath.add(nextWord);

		if (!parents.containsKey(nextWord)) {
			// we've reached the root
			paths.add(extendedPath);
			return;
		}
		for (String parent : parents.get(nextWord)) {
			generatePaths(extendedPath, parent, parents, paths);
		}
	}

	// end{generate-paths}

	// begin{find-ladders}
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> paths = new ArrayList<>();

		if (!dict.contains(start) || !dict.contains(end)) {
			return paths;
		}

		if (start.equals(end)) {
			ArrayList<String> trivial = new ArrayList<>();
			trivial.add(start);
			paths.add(trivial);
			return paths;
		}

		// find all levels using BFS backwardly:
		// source --> end, sink --> start
		HashMap<String, HashSet<String>> parents = buildGraph(end, start, dict);
		if (parents.isEmpty()) {
			return paths;
		}

		ArrayList<String> partialPath = new ArrayList<>();
		generatePaths(partialPath, start, parents, paths);
		return paths;
	}

	
	
	
	   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	        List<List<String>> result = new ArrayList<>();
	        if (start == null || end == null || dict.isEmpty())  return result;
	        if (start.equals(end)) {
	            List<String> tmp = new ArrayList<>();
	            tmp.add(start);
	            result.add(tmp);
	            return result;
	        }
	        Set<String> previousSet = new HashSet<>();
	        Set<String> currentSet = new HashSet<>();
	        Set<String> nextSet = new HashSet<>();
	        previousSet.add(end);
	        currentSet.add(end);
	        Deque<String> q = new LinkedList<>();
	        Deque<String> tmp = new LinkedList<>();
	        Map<String, List<List<String>>> map = new HashMap<>();
	        
	        List<String> endL = new ArrayList<>();
	        endL.add(end);
	        List<List<String>> endLL = new ArrayList<>();
	        endLL.add(endL);
	        map.put(end, endLL);
	        Map<String, List<List<String>>> nextMap = new HashMap<>();
	        q.offer(end);
	        boolean found = false;
	        while (!q.isEmpty()) {
	            String str = q.poll();
	            if (str.equals(start)) {
	                found = true;
	                break;
	            }
	            char[] chars = str.toCharArray();
	            for (int i = 0; i < str.length();i++ ) {
	                for (char c = 'a'; c<='z';c++) {
	                    if (c!= chars[i]) {
	                        char back = chars[i];
	                        chars[i] = c;
	                        String newStr = new String(chars);
	                        if (!previousSet.contains(newStr)
	                             && !currentSet.contains(newStr)
	                             && dict.contains(newStr)) {
	                             nextSet.add(newStr);
	                             tmp.add(newStr);
	                             
	                             if(nextMap.containsKey(newStr)) {
	                                 List<List<String>> current = map.get(str);
	                                 List<List<String>> newC = new ArrayList<>();
	                                 for (List<String> list: current) {
	                                     List<String> newL = new ArrayList<>(list);
	                                     newL.add(0, newStr);
	                                     newC.add(newL);
	                                 }
	                                 nextMap.get(newStr).addAll(newC);
	                                 
	                             } else {
	                                 List<List<String>> current = map.get(str);
	                                 List<List<String>> newC = new ArrayList<>();
	                                 for (List<String> list: current) {
	                                     List<String> newL = new ArrayList<>(list);
	                                     newL.add(0, newStr);
	                                     newC.add(newL);
	                                 }
	                                 nextMap.put(newStr, newC);
	                             }
	                        }
	                        
	                        chars[i] = back;
	                    }
	                }
	            }
	            if (q.isEmpty()) {
	                q = tmp;
	                tmp = new LinkedList<>();
	                previousSet = currentSet;
	                currentSet = nextSet;
	                map = nextMap;
	                nextMap.clear();
	            }
	        }
	        if (found) {
	            return map.get(start);
	        }
	        return result;
	    }
	
}
