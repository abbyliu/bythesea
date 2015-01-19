package leecode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*  Combination Sum
 *  Given a set of candidate numbers (C) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.
    
     O(exponential)
 */
public class Solution {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (candidates == null || candidates.length == 0 || target <=0) return result;
		Arrays.sort(candidates);
		List<Integer> tmp = new ArrayList<>();
		findResult(candidates, result, target, 0, tmp);
		return result;
	}
	
    private void findResult(int[] candidates, List<List<Integer>> result,
			int target, int idx, List<Integer> tmp) {
    	if (target == 0) {
    		result.add(new ArrayList<Integer>(tmp));
    		return;
    	}
    	for (int i = idx; i < candidates.length; i++) {
    		if (candidates[i] > target) {
    			break;
    		}
    		tmp.add(candidates[i]);
    		findResult(candidates, result, target - candidates[i], i, tmp);
    		tmp.remove(tmp.size()-1);
    	}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (target <= 0 || candidates == null || candidates.length == 0) return result;
    	Arrays.sort(candidates);
    	result = findCombinations(candidates, 0, target);
     	return result;
    }
	private List<List<Integer>> findCombinations(int[] candidates, int i ,int target) {
		if (i >= candidates.length) {
			return new ArrayList<List<Integer>>();
		}
		
		if (candidates[i] > target) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> returns = new ArrayList<>();
		for (int idx = 0; idx * candidates[i] <= target; idx++) {
			List<Integer> result = new ArrayList<>();
			for (int j = 0; j < idx; j++) {
				result.add(candidates[i]);
			}
			int v = target - idx * candidates[i];
			if (v > 0) {
				List<List<Integer>> reduced = findCombinations(candidates, i+1, target - idx * candidates[i]);
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
