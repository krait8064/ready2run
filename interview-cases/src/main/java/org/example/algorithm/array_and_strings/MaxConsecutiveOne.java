package org.example.algorithm.array_and_strings;

import org.junit.Assert;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 */
public class MaxConsecutiveOne {
    public int maxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == 1) {
                max = Math.max(max, ++sum);
            } else if (sum != 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOne ma = new MaxConsecutiveOne();
        int res = ma.maxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        Assert.assertEquals(3, res);
    }
}
