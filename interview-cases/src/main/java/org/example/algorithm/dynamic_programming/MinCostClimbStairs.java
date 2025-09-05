package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */


public class MinCostClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2) return Math.min(first, second);
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    public int minCostClimbingStairsLocal(int[] cost) {
        //a[i]=Math.min(a[i-1]+arr[i-1],a[i-2]+arr[i-2])
        if (cost == null || cost.length == 0) {
            return 0;
        } else if (cost.length == 1) {
            return cost[0];
        }

        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int temp = second;
            second = Math.min(second, first) + cost[i];
            first = temp;

        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        MinCostClimbStairs mcs = new MinCostClimbStairs();
        int res = mcs.minCostClimbingStairsLocal(new int[]{10, 15, 20});
        Assert.assertEquals(15, res);
        res = mcs.minCostClimbingStairs(new int[]{10, 15, 20});
        Assert.assertEquals(15, res);

        int res2 = mcs.minCostClimbingStairsLocal(new int[]{1,100,1,1,1,100,1,1,100,1});
        Assert.assertEquals(6, res2);
        res2 = mcs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
        Assert.assertEquals(6, res2);
    }
}
