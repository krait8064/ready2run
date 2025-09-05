package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int indexDif = i - coin;
                if (indexDif >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[indexDif]);
                }
            }
        }

        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
//        int res = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        int res = coinChange.coinChangeLocal(new int[]{1, 2, 5}, 11);
        Assert.assertEquals(res, 3);
    }

    private int coinChangeLocal(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, amount + 1);
        res[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                int indexDif = i - coin;
                if (indexDif >= 0) {
                    res[i] = Math.min(res[i], res[indexDif] + 1);
                }
            }

        }
        return res[amount] != amount + 1 ? res[amount] : -1;
    }
}
