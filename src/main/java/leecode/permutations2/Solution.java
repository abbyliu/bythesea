package leecode.permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*  Permutations II
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
O(n!)
 */
public class Solution {
	   public List<List<Integer>> permuteUnique(int[] num) {
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
