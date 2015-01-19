package leecode.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*  Combination Sum II
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
		s.combinationSum3(num, 2);
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
	

}
