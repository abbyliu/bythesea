package leecode.besttimeforstock3;

import java.util.ArrayList;
import java.util.List;
/*
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
		s.maxProfit3(prices);
	}

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length <=1) return 0;
        int[] leftProfits = new int[prices.length];
        int lowest = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length;i++) {
            max = Math.max(max, prices[i]-lowest);
            leftProfits[i] = max;
            lowest = Math.min(lowest, prices[i]);
        }
        int[] rightProfits = new int[prices.length];
        max = 0;
        int highest = prices[prices.length-1];
        for (int i = prices.length-1; i>=0 ;i--) {
            max = Math.max(max, highest - prices[i]);;
            rightProfits[i] = max;
            highest = Math.max(highest, prices[i]);
        }
        
        max = 0;
        for (int i = 0; i < prices.length-1;i++) {
           max = Math.max(max, leftProfits[i] + rightProfits[i+1]);
        }
        max = Math.max(max, leftProfits[prices.length-1]);
        max = Math.max(max, rightProfits[0]);
        return max;
    }
	
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int[] forwards = new int[prices.length+1];
		int lowest = prices[0];
		for (int i = 2; i < prices.length-1; i++) {
			forwards[i] = Math.max(forwards[i-1], prices[i-1]-lowest);
			lowest = Math.min(lowest, prices[i-1]);
		}
		int[] back = new int[prices.length];
		int highest = prices[prices.length-1];
		for (int i = prices.length-2; i>=0; i--) {
			back[i] = Math.max(back[i+1], highest - prices[i]);
			highest = Math.max(highest, prices[i]);
		}
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, (forwards[i]+ back[i]));
		}
		return max;
	}
    public int maxProfit(int[] prices) {
    	List<Integer> lows  = new ArrayList<>();
    	List<Integer> highs = new ArrayList<>();
    	int len = prices.length;
    	int i = 0;
    	while (i < len) {
    		while (i+1 < len && prices[i+1] <= prices[i]) ++i;
    		lows.add(prices[i]);
    		while( i+1 < len && prices[i+1] >= prices[i]) ++i;
    		highs.add(prices[i]);
    		++i;
    	}
    	
    	int total = 0;
    	int lowSize = lows.size();
    	
    	for (i = 0; i < lowSize;i++) {
    		int j = 0;
    		int low = Integer.MAX_VALUE;
    		int high = 0;
    		int first = 0;
    		int second = 0;
    		
    		while (j <= i) {
    			low = Math.min(low, lows.get(j));
    			high = highs.get(j);
    			first = Math.max(first, (high - low));
    			++j;
    		}
    		
    		low = Integer.MAX_VALUE;
    		high = 0;
    		j = i+1;
    		while ( j < lowSize) {
    			low = Math.min(low, lows.get(j));
    			high = highs.get(j);
    			second = Math.max(second, (high-low));
    			++j;
    		}
    		total = Math.max(total, first + second);
    	}
    	return total;
    }
}