package leecode.besttimeforstock3;

public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length==0) return 0;
        int[] left = new int[prices.length];
        
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length;i++) {
            max = Math.max(max, prices[i]-min);
            left[i] = max;
            min  = Math.min(min, prices[i]);
        }
        
        int[] right = new int[prices.length];
        max = 0;
        int highest = prices[prices.length-1];
        for (int i = prices.length-2; i>=0;i--) {
            max = Math.max(max, highest - prices[i]);
            right[i] = max;
            highest = Math.max(highest, prices[i]);
        }
        max = 0;
        for (int i =0; i < prices.length;i++) {
            if (i < prices.length-1) {
                max = Math.max(max , left[i] + right[i+1]);
            } else {
                max = Math.max(max, left[i]);
            }
        }
        return max;
    }
}