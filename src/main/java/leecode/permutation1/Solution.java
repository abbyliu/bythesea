package leecode.permutation1;

import java.util.ArrayList;
import java.util.List;
/* Permutations

 * Given a collection of numbers, return all possible permutations. 
 * O(factorial)
 */
public class Solution {
	
	public List<List<Integer>> permute2(int[] num) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (num == null || num.length ==0) return result;
	    List<Integer> tmp = new ArrayList<>();
	    result.add(tmp);
	    List<List<Integer>> tp = new ArrayList<>();
	    for (int i = 0; i < num.length;i++) {
	        for (List<Integer> pre: result) {
	            for (int j = 0; j <= pre.size();j++) {
	                List<Integer> copy = new ArrayList<>(pre);
	                copy.add(j, num[i]);
	                tp.add(copy);
	            }
	        }
	        result = tp;
	        tp = new ArrayList<>();
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
