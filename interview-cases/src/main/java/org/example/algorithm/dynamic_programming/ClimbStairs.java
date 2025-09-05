package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prev2 = 3;
        int prev1 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev2 + prev1;
            prev1 = prev2;
            prev2 = cur;
        }

        return cur;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int res = climbStairs.climbStairs(2);
        Assert.assertEquals(2, res);
        int res2 = climbStairs.climbStairs(3);
        Assert.assertEquals(3, res2);
    }
}
