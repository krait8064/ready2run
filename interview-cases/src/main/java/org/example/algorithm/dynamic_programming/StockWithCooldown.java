package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 * <p>
 * Input: prices = [1]
 * Output: 0
 */
public class StockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        boolean coldDown = false;
        for (int i = 1; i < prices.length; i++) {
            if (coldDown) {
                coldDown = false;
                continue;
            }

            if (i == prices.length - 1 && prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
                break;
            }

            if (prices[i] - prices[i - 1] > prices[i + 1] - prices[i]) {
                profit += prices[i] - prices[i - 1];
                coldDown = true;
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        StockWithCooldown stockWithCooldown = new StockWithCooldown();
        int res = stockWithCooldown.maxProfit(new int[]{1, 2, 3, 0, 2});
        Assert.assertEquals(3, res);
    }
}
