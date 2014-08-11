package leecode.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 *  Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is: 
 */
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S == null || S.length == 0) return result;
        int loop = 1 << S.length;
        for (int i = 0; i < loop ;i++) {
        	List<Integer> iresult = new ArrayList<>();
        	int idx = i;
        	int index = 0;
        	while (idx > 0) {
        		if ((idx & 1) != 0) {
        			iresult.add(S[index]);
        		}
        		index++;
        		idx = idx >> 1;
        	}
        	Collections.sort(iresult);
        	result.add(iresult);
        }
        return result;
    }
}