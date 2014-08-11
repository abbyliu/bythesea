package leecode.permutation1;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a collection of numbers, return all possible permutations. 
 */
public class Solution {
	
	public List<List<Integer>> permute2(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		if (num == null || num.length == 0) return result;
		List<Integer> first = new ArrayList<>();
		result.add(first);
		first.add(num[0]);
		for (int i = 1 ; i< num.length;i++ ) {
			int v = num[i];
			List<List<Integer>> ii = new ArrayList<>();
			for (List<Integer> rr : result) {
				for (int k = 0; k <= rr.size();k++) {
					List<Integer> iss = new ArrayList<>(rr);
					iss.add(k, v);
					ii.add(iss);
				}
			}
			result = ii;
		}
		return result;
	}
    public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (num == null || num.length == 0) return result;
    	result = findPerms(num, 0);
    	return result;
    }
    
    
	private List<List<Integer>> findPerms(int[] num, int i) {
		if (i == num.length-1) {
			List<Integer> is = new ArrayList<>();
			is.add(num[i]);
			List<List<Integer>> result = new ArrayList<>();
			result.add(is);
			return result;
		}
		List<List<Integer>> res = findPerms(num, i+1);
		List<List<Integer>> result = new ArrayList<>();
		for (List<Integer> is: res) {
			for (int jj = 0; jj <=is.size(); jj++) {
				List<Integer> iss = new ArrayList<>(is);
				iss.add(jj, num[i]);
				result.add(iss);
			}
		}
		return result;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] p  = {0,1};
		s.permute2(p);
	}

}
