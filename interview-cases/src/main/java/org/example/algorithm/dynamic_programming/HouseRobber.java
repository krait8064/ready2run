package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 */
public class HouseRobber {


    public int robLocal(int[] nums) {
//        rob i = Math.Max(rob i-2+cur,rob i -1)
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robLen(nums, memo, nums.length - 1);
    }

    private int robLen(int[] nums, int[] memo, int len) {
        if (len < 0) {
            return 0;
        }
        if (memo[len] >= 0) {
            return memo[len];
        }
        int result = Math.max(robLen(nums, memo, len - 2) + nums[len], robLen(nums, memo, len - 1));
        memo[len] = result;
        return result;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
//        int res = houseRobber.robLocal(new int[]{1, 2, 3, 1});
        int res = houseRobber.robLocalRes(new int[]{1, 2, 3, 1});
        Assert.assertEquals(4, res);
        int res2 = houseRobber.robLocalRes(new int[]{2, 7, 9, 3, 1});
        Assert.assertEquals(12, res2);
    }

    int[] memo;

//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        int[] memo = new int[nums.length + 1];
//        memo[0] = 0;
//        memo[1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int val = nums[i];
//            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
//        }
//        return memo[nums.length];
//    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int cur : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + cur, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }

    public int robLocalRes(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int cur : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + cur, prev1);
            prev2 = temp;
        }

        return prev1;
    }
}
