package leecode.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 *  Given a collection of candidate numbers (C) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination. 

O(exponential)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2};
		Solution s = new Solution();
		s.combinationSum2(num, 2);
	}
	
	public List<List<Integer>> combinationSum3(int[] num , int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (num == null || num.length == 0) return result;
		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(num);
		find(result, num, 0, target, tmp);
		return result;
	}
	
	private void find(List<List<Integer>> result, int[] num, int idx, int target, List<Integer> tmp) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		if (idx >= num.length) return;
		if (num[idx] > target) return;
		for (int i = idx; i < num.length; i++) {
			if (i > idx && num[i] == num[i-1]) continue;
			tmp.add(num[i]);
			find(result, num, i+1, target - num[i], tmp);
			tmp.remove(tmp.size()-1);
		}
	}
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	Set<List<Integer>> result = new HashSet<>();
    	if (target <= 0 || num == null || num.length == 0) return new ArrayList<List<Integer>>(result);
    	Arrays.sort(num);
    	result = findCombinations(num, 0, target);
     	return new ArrayList<List<Integer>>(result);
    }
	private Set<List<Integer>> findCombinations(int[] candidates, int i ,int target) {
		if (i >= candidates.length) {
			return new HashSet<List<Integer>>();
		}
		
		if (candidates[i] > target) {
			return new HashSet<List<Integer>>();
		}
		Set<List<Integer>> returns = new HashSet<>();
		for (int idx = 0; idx * candidates[i] <= target && idx < 2; idx++) {
			List<Integer> result = new ArrayList<>();
			for (int j = 0; j < idx; j++) {
				result.add(candidates[i]);
			}
			int v = target - idx * candidates[i];
			if (v > 0) {
				Set<List<Integer>> reduced = findCombinations(candidates, i+1, target - idx * candidates[i]);
				for (List<Integer> red: reduced) {
					red.addAll(0,result);
					returns.add(red);
				}
			} else {
				returns.add(result);
			}
		}
		return returns;
	}

}
