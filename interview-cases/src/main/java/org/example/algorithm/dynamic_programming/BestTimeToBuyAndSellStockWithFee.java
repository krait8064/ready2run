package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

/**
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * <p>
 * Note:
 * <p>
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 * <p>
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 * solution
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/">...</a>
 */
public class BestTimeToBuyAndSellStockWithFee {
    public int maxProfitLocal(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int prev = prices[0];
        int buyPrice = prices[0];

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if (prev - cur > fee) {
                profit += prev - buyPrice - fee;
                buyPrice = cur;
            } else if (i == prices.length - 1 && cur - buyPrice > fee) {
                profit += cur - buyPrice - fee;
            }
            prev = cur;
        }

        return profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
        }

        return T_ik0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithFee stockWithFee = new BestTimeToBuyAndSellStockWithFee();
        int res = stockWithFee.maxProfitLocal(new int[]{1, 3, 2, 8, 4, 9}, 2);
        Assert.assertEquals(8, res);
        res = stockWithFee.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        Assert.assertEquals(8, res);
        int res2 = stockWithFee.maxProfitLocal(new int[]{1, 3, 7, 5, 10, 3}, 3);
        Assert.assertEquals(6, res2);
        res2 = stockWithFee.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
        Assert.assertEquals(6, res2);

    }
}
