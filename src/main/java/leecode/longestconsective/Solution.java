package leecode.longestconsective;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*  Longest Consecutive Sequence
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
O(n)
O(n)
 */
public class Solution {
	public int longestConsecutive2(int[] num) {
		if (num== null ||num.length == 0) return 0;
		Set<Integer> nums = new HashSet<>();
		for (int i : num) {
			nums.add(i);
		}
		int max  = 1;
		for (int i : num) {
			int left = i-1;
			int right = i+1;
			int count = 1;
			while (nums.contains(left)) {
				nums.remove(left);
				count++;
				left--;
			}
			while (nums.contains(right)) {
				nums.remove(right);
				count++;
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
	public int longestConsecutive(int[] num) {
	    Map<Integer, Integer> sequence = new HashMap<Integer, Integer>();
	    int longest = 0;
	    for (int i = 0; i < num.length; i++) {
	        if (sequence.containsKey(num[i])) continue;
	        int lowerbound = num[i];
	        int upperbound = num[i];
	        if (sequence.containsKey(num[i] - 1)) // Get the lowerbound
	            lowerbound = sequence.get(num[i] - 1);
	        if (sequence.containsKey(num[i] + 1))// Get the Upperbound
	            upperbound = sequence.get(num[i] + 1);
	        longest = Math.max(longest, (upperbound - lowerbound)+ 1);
	        sequence.put(num[i],num[i]);
	        sequence.put(lowerbound, upperbound);
	        sequence.put(upperbound, lowerbound);
	    }
	    return longest;
	}
}