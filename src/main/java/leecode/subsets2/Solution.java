package leecode.subsets2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*  Subsets II
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
O(exp)
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	Set<List<Integer>> sets = new HashSet<>();
    	
    	if (num == null || num.length == 0) {
    		List<List<Integer>> result = new ArrayList<>(sets);
    		return result;
    	}
    	int loop = 1 << num.length;
    	for (int i = 0; i < loop; i++) {
    		List<Integer> is = new ArrayList<>();
    		int idx = i;
    		int start = 0;
    		while (idx != 0) {
    			int result = idx & 1;
    			if (result != 0) {
    				is.add(num[start]);
    			}
    			start++;
    			idx = idx >> 1;
    		}
    		Collections.sort(is);
    		sets.add(is);
    	}
		List<List<Integer>> result = new ArrayList<>(sets);
		return result;
    }
}
