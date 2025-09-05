package org.example.algorithm.array_and_strings;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 *
 */
public class MoveZero {
    public int[] moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        return nums;
    }

    public int[] moveZeroesLocal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] res = moveZero.moveZeroesLocal(new int[]{0, 1, 0, 3, 12});
        Assert.assertArrayEquals(res, new int[]{1,3,12,0,0});
        res = moveZero.moveZeroes(new int[]{0, 1, 0, 3, 12});
        Assert.assertArrayEquals(res, new int[]{1,3,12,0,0});

    }
}
