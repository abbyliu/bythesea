package leecode.besttimeforstock3;

/* Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 O(n) . O(n) .
 */
public class Solution {
	public static void main(String[] args) {
		int[] prices = {3,2,6,5,0,3};
		Solution s = new Solution();
		s.maxProfit(prices);
	}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int[] before = new int[prices.length];
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
             max = prices[i] - min;
            }
            before[i] = max;
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        
        int[] after = new int[prices.length];
        int maxx = prices[prices.length-1];
        max = 0;
        for (int i = prices.length-2; i>=0; i--) {
            if (maxx - prices[i] > max) {
                max = maxx - prices[i];
            }
            after[i] = max;
            if (prices[i] > maxx) {
                maxx = prices[i];
            }
        }
        
        max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (before[i] + after[i+1] > max) {
                max = before[i] + after[i+1];
            }
        }
        
        if (before[prices.length-1] > max) {
            max = before[prices.length-1];
        }
        
        return max;
    }
        
}