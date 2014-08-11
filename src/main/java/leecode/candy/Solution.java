package leecode.candy;

import java.util.ArrayList;
import java.util.List;
/*
 *  There are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

	What is the minimum candies you must give? 
	O(n), O(1)
 */
public class Solution {
	
	  public int candy3(int[] ratings) {
	        if (ratings == null || ratings.length == 0) return 0;
	        int candies = ratings.length;
	        int idx = 0;
	        while (idx < ratings.length-1) {
	            int start = idx;
	            while (idx < ratings.length-1 && ratings[idx]<ratings[idx+1]) {
	                idx++;
	            }
	            int range = idx -start;
	            int v = range * (range+1)/2;
	            candies += v;

	            start  = idx;
	            while (idx < ratings.length-1 && ratings[idx] > ratings[idx+1]) {
	                idx++;
	            }
	            int range2 = idx-start-1;
	            v = range2 * (range2+1)/2;
	            candies +=v;
	            if (range2+1 > range) {
	                candies += (range2+1-range);
	            }
	            if (idx < ratings.length-1 && ratings[idx] == ratings[idx+1]) {
	                idx++;
	            }
	        }
	        return candies;        
	    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] ratings = new int[] {1,2,4,4,4,3,2,1};
		int v = s.candyNoExtraSpace(ratings);
		System.out.println(v);
		v = s.candy(ratings);
		System.out.println(v);
	}
	public int candy2(int[] ratings) {
		if (ratings == null || ratings.length == 0) return 0;
		int min = ratings.length;
		int range = 0;
		int n = ratings.length;
		for (int i = 0; i < n-1;) {
			int start = i ;
			while (i < n-1 && ratings[i] < ratings[i+1]) {
				i++;
			}
			range = i - start ;
			min = min + (range * (range+1))/2;
			if (i == n-1) break;
			start = i;
			while (i < n-1 && ratings[i] > ratings[i-1]) {
				i++;
			}
			int k = i - start - 1;
			min = min + (k * (k+1))/2;
			if (i - start > range) {
				min = min + (i-start - range);
			}
			if ( i < n-1 && ratings[i] == ratings[i+1]);
		}
		return min;
		
	}
	public int candyNoExtraSpace(int[] ratings) {
		int n = ratings.length;
		int min = n;
		int range = 0;
		for(int i = 0; i < n -1;) {
			int start = i;
			while ( i < n -1 && ratings[i]< ratings[i+1]) ++i;
			range  = i - start;
			min = min + (range * (range+1))/2;
			if ( i == n-1) break;
			start  = i;
			while (i < n-1 && ratings[i] > ratings[i+1] ) ++i;
			int k = i - start - 1;
			min = min + (k*(k+1))/2;
			if ( i - start > range) min= min+ (i-start - range);
			if (i < n -1  && ratings[i] == ratings[i+1]) ++i;
		}
		return min;
	}
    public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0) return 0;
    	if (ratings.length == 1) return  1;
    	
    	int length = ratings.length;
    	int[] result = new int[length];
    	for (int i = 0; i < length ; i++) {
    		result[i] = 1;
    	}
    	List<Integer> pivotPoints = new ArrayList<>();
    	boolean decline = true;
    	for (int i = 0; i < ratings.length-1; i++) {
    		if (decline && ratings[i] < ratings[i+1]) {
    			pivotPoints.add(i);
    			decline = false;
    		} else if (ratings[i] >= ratings[i+1]) {
    			decline = true;
    		}
    	}
    	
    	if (decline) {
    		pivotPoints.add(ratings.length -1);
    	}
    	for (int i : pivotPoints) {
    		int idx = i; 
    		boolean bigger = true;
    		while (idx >0 && bigger) {
    			if (ratings[idx-1] == ratings[idx]) {
    				idx --;
    			} else if (ratings[idx-1] > ratings[idx]) {
    				if (result[idx] + 1 > result[idx-1]) {
    					result[idx-1] = result[idx] + 1;
    					idx--;
    				} else {
    					bigger = false;
    				}
    			} else {
    				bigger = false;
    			}
    		}
    		idx = i;
    		boolean smaller = true;
    		while (idx < length -1 && smaller) {
    			if ( ratings[idx+1] == ratings[idx]) {
    				idx ++ ;
    			} else  if (ratings[idx+1] > ratings[idx]){
    				if (result[idx] + 1 > result[idx+1]) {
    					result[idx+1] = result[idx] + 1;
    					idx++;
    				} else {
    					smaller = false;
    				}
    			} else {
    				smaller = false;
    			}
    		}
    	}
    	int count = 0;
    	for (int value: result) {
    		count += value;
    	}
    	return count;
    	
    }
}