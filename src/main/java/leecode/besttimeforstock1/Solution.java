package leecode.besttimeforstock1;
/*
 * O(n) , and O(1) space
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution ();
		int[] prices = {4,3,2};
		s.maxProfit(prices);
	}
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	int n = prices.length;
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 0;i < n ; i++) {
    		min = Math.min(min, prices[i]);
    		max = Math.max(max, (prices[i] - min));
    	}
    	return max;
    }

    public int maxProfit2(int[] prices) {
    	if (prices == null || prices.length <=1) return 0;
    	int min = prices[0];
    	int max = Integer.MIN_VALUE;
    	for (int i = 1 ;i < prices.length; i++) {
    		min = Math.min(min,  prices[i]);
    		max = Math.max(max, (prices[i]-min));
    	}
    	if (max <0) return 0;
    	else return max;
    }
}
