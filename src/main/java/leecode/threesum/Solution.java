package leecode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* 3Sum

 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * O(N2)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> threeSum(int[] num) {
        // two pointer runner solution O(N^2 + NlogN)
       if (num.length < 3) return new ArrayList<List<Integer>>();
       Arrays.sort(num);
       List<List<Integer>> triplets = new ArrayList<>();
       for (int i = 0; i < num.length - 1; ) {
           int j = i + 1;
           int k = num.length - 1;
           while (j < k) {
               int sum = num[i] + num[j] + num[k];
               // remove duplication when you move i,j or k
               if (sum > 0) while (num[k] == num[--k] && num[j] <= num[k] && j < k);
               else if (sum < 0) while (num[j] == num[++j] && num[j] <= num[k] && j < k);
               else {
                   ArrayList<Integer> list = new ArrayList<>();
                   list.add(num[i]);
                   list.add(num[j]);
                   list.add(num[k]);
                   triplets.add(list);
                   while (num[k] == num[--k] && num[j] <= num[k] && j < k);
                   while (num[j] == num[++j] && num[j] <= num[k] && j < k);                          
               }
           }
           while (num[i] == num[++i] && i < num.length - 2);
       }
       return triplets;  
   }
	
    public List<List<Integer>> threeSum2(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length <3 ) return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
            if (i > 0 && num[i] == num[i-1] ) continue;
            int left = i+1;
            int right = num.length-1;
            while (left < right) {
                int expected = 0 - num[i];
                int v = num[left] + num[right];
                if (v == expected) {
                            List<Integer> ret = new ArrayList<>();
                            ret.add(num[i]);
                            ret.add(num[left]);
                            ret.add(num[right]);
                            result.add(ret);
                            do {
                                left ++;
                            } while (left < right && num[left]==num[left-1]);
                            do {
                                right --;
                            } while (left < right && num[right]==num[right+1]);
                } else if ( v < expected) {
                    do {
                        left++;
                    } while(left < right && num[left-1] == num[left]);
                } else {
                    do {
                        right--;
                    }while(left < right && num[right] == num[right+1]);
                }
            }
       }
        return result;
    }
}
