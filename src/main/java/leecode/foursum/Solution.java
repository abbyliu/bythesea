package leecode.foursum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
The solution set must not contain duplicate quadruplets.
O(n2) average, worse O(n3), space O(n2)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,1,0,-1};
		Solution s = new Solution ();
		s.fourSum(num, 2);
	}

	static class Pair  {
		public int x;
		public int y;
		public Pair(int xx, int yy) {
			x = xx;y=yy;
		}
	}
	
	public List<List<Integer>> fourSum2(int[] num, int target) {
		Set<List<Integer>> result = new HashSet<>();
		if (num == null || num.length <4) return Collections.emptyList();
		Map<Integer, List<Pair>> pair = new HashMap<>();
		for (int i = 0; i < num.length-1; i++) {
			//if (i > 0 && num[i] == num[i-1]) continue;
			for (int j = i+1; j < num.length;j++) {
				if (j > i+1 && num[j] == num[j-1]) {
					//continue;
				}
				int v = num[i] + num[j];
				if (!pair.containsKey(v)) {
					List<Pair> ps = new ArrayList<>();
					ps.add(new Pair(i,j));
					pair.put(v, ps);
				} else {
					pair.get(v).add(new Pair(i,j));
				}
			}
		}
		Set<Integer> twos = new HashSet<>(pair.keySet());

		for (Integer v: twos) {
			if (pair.containsKey(target - v)) {
				result.addAll(combine2(num, pair.get(v), pair.get(target-v)));
				pair.remove(v);
				pair.remove(target-v);
			}
		}
		
		return new ArrayList<List<Integer>>(result);
	}
	private Collection<? extends List<Integer>> combine2(int[] num, List<Pair> value
			, List<Pair> value2) {
		Set<List<Integer>> result = new HashSet<>();
		for (Pair p1: value) {
			for (Pair p2: value2) {
				List<Integer> list = combinePair(num, p1,p2);
				if (list.size() ==4) {
					result.add(list);
				}
			}
		}
		
		return result;
	}
	private List<Integer> combinePair(int[] num, Pair p1, Pair p2) {
		if (p1.y == p2.x || p1.x == p2.y || p1.x == p2.x || p1.y == p2.y) return Collections.emptyList();
		List<Integer> is = new ArrayList<>();
		is.add(num[p1.x]);is.add(num[p1.y]);
		is.add(num[p2.x]);is.add(num[p2.y]);
		Collections.sort(is);
		return is;
	}
	public List<List<Integer>> fourSum(int[] num, int target) {
		Set<List<Integer>> result = new HashSet<>();
		if (num.length < 4) return new ArrayList<>(result);
		
		Map<Integer, List<Pair>> map = new HashMap<>();
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length ;j++) {
				int v = num[i] + num[j];
				if (!map.containsKey(v)) {
					List<Pair> is = new ArrayList<>();
					is.add(new Pair(i,j));
					map.put(v, is);
				} else {
					map.get(v).add(new Pair(i,j));
				}
			}
		}
		Set<Integer> twos = new HashSet<>(map.keySet());
		for(Integer in: twos) {
			if (map.containsKey(target - in)) {
				result.addAll(combine(map.get(in), map.get(target-in), num));
				map.remove(in);
				map.remove(target-in);
			}
		}
		return new ArrayList<>(result);
	}
	private Set<List<Integer>> combine(List<Pair> list,
			List<Pair> list2, int[] num) {
		Set<List<Integer>> result = new HashSet<>();
		for (Pair p1: list) {
			for (Pair p2: list2) {
				List<Integer> rt = combinePair(p1, p2, num);
				if (rt.size() == 4) {
					result.add(rt);
				}
			}
		}
		return result;
	}
	private List<Integer> combinePair(Pair p1, Pair p2 ,int[] num) {
		List<Integer> ins = new ArrayList<>();
		if (p1.x == p2.x || p1.x== p2.y || p1.y == p2.x || p1.y==p2.y) return ins;
		ins.add(num[p1.x]);ins.add(num[p2.x]);ins.add(num[p1.y]);ins.add(num[p2.y]);
		Collections.sort(ins);
		return ins;
	}
}
