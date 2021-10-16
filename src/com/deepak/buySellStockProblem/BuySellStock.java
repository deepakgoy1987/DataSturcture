package com.deepak.buySellStockProblem;

import com.sun.management.OperatingSystemMXBean;

public class BuySellStock {
	
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	/*
	You are given an array prices where prices[i] is the price of a given stock on the ith day.

	You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in 
	the future to sell that stock.

	Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0


	Example 1:

	Input: prices = [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
	Example 2:

	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transactions are done and the max profit = 0.


	*/

	public static int maxProfit(int[] prices) {
	    
	    int maxProfit = 0;
	    int min_index = 0;
	    int buying_index = 0;
	    int sell_index = 0;
	    
	    for(int i = 1 ; i < prices.length ; i++) {
	    	int profit = prices[i] - prices[min_index];
	    	
	    	if(profit > maxProfit) {
	    		maxProfit = profit;
	    		buying_index = min_index;
	    		sell_index = i;
	    	}else if(prices[i] < prices[min_index]) {
	    		min_index = i;
	    	}
	    }
	    
	    return maxProfit;
	    
	}
	
	
	
/*	
	You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

	On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of 
	the stock at any time. However, you can buy it then immediately sell it on the same day.

	Find and return the maximum profit you can achieve.
	
	Example 1:

	Input: prices = [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	Total profit is 4 + 3 = 7.
	Example 2:
	
	Input: prices = [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	Total profit is 4.
	Example 3:
	
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
	
	
	
	
	
	*/
	
	
public static int maxProfitWithMulitpleTransaction(int[] prices) {
	    
	    int maxProfit = 0;
	    
	    for(int i = 1 ; i < prices.length ; i++) {
	    	//next price is greator then previous one then add into profit other sell it and buy again 
	    	if(prices[i] > prices[i-1]) {
	    		maxProfit += prices[i] - prices[i-1];
	    	}else {
	    		//print indexs 
	    		if(maxProfit != 0) {
	    		  System.out.println("buying index =   " + (i-1));
	    		  System.out.println("Selling index = " + i) ;
	    		}
	    	}
	    	
	     }
	    
	    return maxProfit;
	    
	}
	
	
	
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions 
at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
Example 4:

Input: prices = [1]
Output: 0




*/



public static int maxProfitWith2Transactions(int[] prices) {
	if (prices.length == 0)
		return 0;

	int minPrice = prices[0];
	int maxProfitAfterFirstSell = 0;
	int maxProfitLeftAfterSecondBuy = Integer.MIN_VALUE;
	int maxProfitAfterSecondSell = 0;

	for (int i = 1; i < prices.length; i++) {
		int price = prices[i];
		
		maxProfitAfterFirstSell = Math.max(price - minPrice, maxProfitAfterFirstSell);
		minPrice = Math.min(price, minPrice);
		//what profit remaining after purchasing stock second time 
		maxProfitLeftAfterSecondBuy = Math.max(maxProfitAfterFirstSell - price, maxProfitLeftAfterSecondBuy);
		maxProfitAfterSecondSell = Math.max(price + maxProfitLeftAfterSecondBuy, maxProfitAfterSecondSell);
	}
	return maxProfitAfterSecondSell;
}
	
	
	
	
	
	
	
	
	
	

}











