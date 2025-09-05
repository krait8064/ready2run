package org.example.algorithm.array_and_strings;

import org.example.reader.Solution;
import org.junit.Assert;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public int[] sortedSquaresLocal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();
        int[] res = solution.sortedSquaresLocal(new int[]{-4, -1, 0, 3, 10});
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, res);
        res = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, res);
        int[] res2 = solution.sortedSquaresLocal(new int[]{-7, -3, 2, 3, 11});
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, res2);
        res2 = solution.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, res2);
    }
}
