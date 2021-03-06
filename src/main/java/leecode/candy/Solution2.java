package leecode.candy;

import java.util.Arrays;

public class Solution2 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < ratings.length;i++) {
            if (ratings[i-1] < ratings[i]) {
                candies[i]  = candies[i-1]+1;
            }
        }
        for (int i = ratings.length-2; i>=0;i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        int sum = 0;
        for (int value: candies) {
            sum+=value;
        }
        return sum;
    }
}