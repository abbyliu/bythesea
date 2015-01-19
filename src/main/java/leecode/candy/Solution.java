package leecode.candy;

/*  Candy
 *  There are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

	What is the minimum candies you must give? 
	O(n), O(1)
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] ratings = new int[] {1,2,4,4,4,3,2,1};
		int v = s.candy2(ratings);
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
}