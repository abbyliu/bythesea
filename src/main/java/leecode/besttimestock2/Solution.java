package leecode.besttimestock2;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions 
at the same time (ie, you must sell the stock before you buy again).

O(n) and O(1) , 
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}

		return total;
	}
	
	public int maxProfit2(int[] prices) {
		if (prices == null ||  prices.length <=1) return 0;
		int total = 0;
		int previousSmall  = 0;
		boolean increase = true;
		for (int i =1 ;i < prices.length; i++) {
			if (prices[i] < prices[i-1]) {
				if (increase) {
					total += (prices[i-1] - prices[previousSmall]);
					increase = false;
				} 
			} else if (prices[i] > prices[i-1]){
				if (!increase) {
					increase = true;
					previousSmall = i-1;
				}
			}
		}
		if (increase) {
			total+= (prices[prices.length-1] - prices[previousSmall]);
		}
		return total;
	}
}
