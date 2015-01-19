package leecode.besttimeforstock1;
/* Best Time to Buy and Sell Stock
 * O(n) , and O(1) space
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution ();
		int[] prices = {4,3,2};
		s.maxProfit(prices);
	}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length ==0) {
            return 0;
        }
        
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i]-min, max);
            min = Math.min(min, prices[i]);
        }
        
        return max;
    }
    
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length ==0) {
            return 0;
        }
        
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	int vv = prices[i] - min;
        	if (vv > max) {
        		max = vv;
        	}
        	if (prices[i] < min) {
        		min = prices[i];
        	}
        }
        
        return max;
    }
}
