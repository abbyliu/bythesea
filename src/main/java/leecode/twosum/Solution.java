package leecode.twosum;

import java.util.HashMap;
import java.util.Map;
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	if (numbers == null || numbers.length < 2) return null;
    	int[] result = new int[2];
    	int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i < numbers.length; i++) {
        	if (map.containsKey(target - numbers[i])) {
        		result[idx] = map.get(target - numbers[i])+1;
        		result[idx+1] = i+1;
        	} else {
        		map.put(numbers[i], i);
        	}
        }
        return result;
    }
}