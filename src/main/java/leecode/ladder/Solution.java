package leecode.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/*
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
	private int min =Integer.MAX_VALUE;
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
			for (Node n: adjs) {
				builder.append(n.v).append(",");
			}
			builder.append("]");
			return v + builder.toString();
		}
	}
	private Map<String, Node> getGraph(Set<String> dict) {
		Map<String, Node> graph = new HashMap<>();
		for (String s: dict) {
			Node n = graph.get(s);
			if (n == null) {
				n = new Node(s);
			}
			graph.put(s, n);
			StringBuffer replace = new StringBuffer(s);
			for (int i = 0; i< s.length(); i++) {
				char old = replace.charAt(i);
				for (char ch = 'a' ; ch<='z'; ch++) {
					if (ch != old) {
						replace.setCharAt(i, ch);
						String replaced = replace.toString();
						if (dict.contains(replaced)) {
							Node adj = graph.get(replaced);
							if (adj == null) {
								adj = new Node(replaced);
								adj.adjs.add(n);
								graph.put(replaced, adj);
							}
							n.adjs.add(adj);
						}
						replace.setCharAt(i, old);
					}
				}
			}
		}
		return graph;
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		Map<String, Node> graph = getGraph(dict);
		//System.out.println(graph);
		if (!dict.contains(start) || !dict.contains(end)) {
			ArrayList<ArrayList<String>> empty = new ArrayList<>();
			return empty;
		}
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		List<String> visited = new ArrayList<>();
		dfs(graph.get(start), graph.get(end), result, visited);
		int min = Integer.MAX_VALUE;
		for (List<String> cand: result) {
			if (cand.size() < min) {
				min = cand.size();
			}
		}
		ArrayList<ArrayList<String>> finals = new ArrayList<>();
		for (ArrayList<String> cand: result) {
			if (cand.size() == min) {
				finals.add(cand);
			}
		}
		
		return finals;
	}

	private void dfs(Node s, Node end, 
		ArrayList<ArrayList<String>> result, List<String> visited) {
		if (s.v.equals(end.v)) {
			visited.add(end.v);
			result.add(new ArrayList(Arrays.asList(visited.toArray())));
			if (visited.size() < min) {
				min = visited.size();
			}
			return;
		} else {
			for (Node node: s.adjs) {
				if (visited.contains(node.v)) {
					continue;
				}
				List<String> temp = new ArrayList<>();
				temp.addAll(visited);
				temp.add(s.v);
				if (temp.size() > min) {
					continue;
				}
			    dfs(node, end, result, temp);
			}
		}
	}
	

	public ArrayList<ArrayList<String>> findLadders2(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (dict.isEmpty()) return result;
		Queue<String> q = new LinkedList<>();
		Queue<String> tempQ = new LinkedList<>();
		q.offer(start);
		ArrayList<String> starts = new ArrayList<>();
		starts.add(start);
		if (start.equals(end)) {
			result.add(starts);
			return result;
		}
		Map<String, List<String>> output = new HashMap<>();
		output.put(start, starts);
		int minSteps = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			String s = q.poll();
			if ( s.equals(end)) {
				break;
			}
			List<String> smap = output.get(s);
			for (int i = 0; i < s.length(); i++) { //
				char[] arr = s.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (arr[i] != c) {
						arr[i] = c;
						String test = new String(arr);
						if (dict.contains(test) && !smap.contains(test)) {
							tempQ.add(test);
							ArrayList<String> ext = new ArrayList<>(smap);
							ext.add(test);
							if (!test.equals(end)) {
								output.put(test, ext);
							} else {
								if (ext.size() <= minSteps) {
									minSteps = ext.size();
									result.add(ext);
								}
							}
						}
					}
				}
			}
			if (q.isEmpty()) {
				q = tempQ;
				tempQ = new LinkedList<>();
			}
		}
		return result;
	}
} 