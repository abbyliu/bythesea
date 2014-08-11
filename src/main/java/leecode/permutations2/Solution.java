package leecode.permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
 */
public class Solution {
    public List<List<Integer>> permute(int[] num) {
    	Set<List<Integer>> result = new HashSet<>();
    	if (num == null || num.length == 0) return new ArrayList<List<Integer>>(result);
    	result = findPerms(num, 0);
    	return new ArrayList<List<Integer>>(result);
    }
    
    public List<List<Integer>> permute2(int[] num) {
    	List<List<Integer> > result = new ArrayList<>();
    	if (num == null || num.length ==0) return result;
    	Arrays.sort(num);
    	boolean[] used = new boolean[num.length];
    	List<Integer> tmp = new ArrayList<>();
    	findPerms(used, num,  tmp, result);
    	return result;
    }
    
    
    
	private void findPerms(boolean[] used, int[] num, List<Integer> tmp,
			List<List<Integer>> result) {
		if (tmp.size() == num.length) {
			List<Integer> copy = new ArrayList<>(tmp);
			result.add(copy);
			return ;
		}
		for (int i = 0; i < num.length; i++) {
			if (i>0 && !used[i-1] && num[i] == num[i-1]) {
				continue;
			}
			if (!used[i]) {
				tmp.add(num[i]);
				used[i] = true;
				findPerms(used, num, tmp,result);
				used[i] = false;
				tmp.remove(tmp.size()-1);
			}
		}
		
	}

	private Set<List<Integer>> findPerms(int[] num, int i) {
		if (i == num.length-1) {
			List<Integer> is = new ArrayList<>();
			is.add(num[i]);
			Set<List<Integer>> result = new HashSet<>();
			result.add(is);
			return result;
		}
		Set<List<Integer>> res = findPerms(num, i+1);
		Set<List<Integer>> result = new HashSet<>();
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

	}

}
