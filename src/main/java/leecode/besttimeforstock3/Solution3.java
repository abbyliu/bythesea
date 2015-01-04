package leecode.besttimeforstock3;

public class Solution3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int[] before = new int[prices.length];
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            before[i] = max;
            min = Math.min(prices[i], min);
        }
        
        int[] after = new int[prices.length];
        int maxx = prices[prices.length-1];
        max = 0;
        for (int i = prices.length-2; i>=0; i--) {
        	max = Math.max(maxx - prices[i], max);
            after[i] = max;
            maxx = Math.max(maxx, prices[i]);
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
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 s3 = new Solution3();
		s3.maxProfit(new int[]{3,2,6,5,0,3});
	}

}
