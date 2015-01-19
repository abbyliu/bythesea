package leecode.threesumclosest;

import java.util.Arrays;
/* 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * O(N2)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int threeSumClosest(int[] num, int target) {
	       if (num.length < 3) return 0;
	       Arrays.sort(num);
	       int currentSum = num[0] + num[1] + num[2];
	       for (int i = 0; i < num.length - 1; ) {
	           int j = i + 1;
	           int k = num.length - 1;
	           while (j < k) {
	               int sum = num[i] + num[j] + num[k];
	               if (sum > target) while (num[k] == num[--k] && num[j] <= num[k] && j < k);
	               else if (sum < target) while (num[j] == num[++j] && num[j] <= num[k] && j < k);
	               else {
	            	   return target;
	               }
	               
	               if (Math.abs(sum * 1l-target*1l)
	            		   < Math.abs(currentSum*1l - target*1l)
	            		   ) {
	            	   currentSum =sum;
	               }
	           }
	           while (num[i] == num[++i] && i < num.length - 2);
	       }
	       return currentSum; 
	}
}
