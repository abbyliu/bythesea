package leecode.permutationsequence;

import java.util.ArrayList;
import java.util.List;
/*
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
O(n)
 */
public class Solution {
	
	public String getPermutatino2(int n, int k) {
		List<Integer> data = new ArrayList<>();
		for (int i = 1; i <=n ;i++) {
			data.add(i);
		}
		int total = 1;
		for (int i = 1; i <=n;i++) {
			total *= i;
		}
		
		if ( k > total) {
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		k = k -1;
		while (n  > 0 ) {
			total = total/n;
			int selected = k/total;
			builder.append(data.get(selected));
			data.remove(selected);
			n--;
			k  = k %total;
		}
		return builder.toString();
	}
    public String getPermutation(int n, int k) {
    	List<Integer> sets = new ArrayList<>();
    	for (int i = 1; i <=n;i++) {
    		sets.add(i);
    	}
    	int result = 1;
    	for (int i = 1; i <=n; i++) {
    		result *=i;
    	}
    	int kk = k-1;
    	StringBuilder builder = new StringBuilder();
    	for (int i = 0 ;i < n; i++) {
    		result = result/(n-i);
    		int choosed = kk/result;
    		builder.append(sets.get(choosed));
    		sets.remove(choosed);
    		kk = kk % result;
    		
    	}
    	return builder.toString();
	}
    public static void main(String[] args) {
    	Solution s= new Solution();
    	s.getPermutation(2,2);
    }
}
