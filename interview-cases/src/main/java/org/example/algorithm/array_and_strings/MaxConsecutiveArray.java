package org.example.algorithm.array_and_strings;

public class MaxConsecutiveArray {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Left pointer for sliding window
        int left = 0;

        // Counter for number of zeros in current window
        int zeroCount = 0;

        // Iterate through array with right pointer (implicit)
//        for (int num : nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // If current number is 0, increment zero count
            // XOR with 1 converts: 0 -> 1 (true), 1 -> 0 (false)
            zeroCount += num ^ 1;

            // If we have more than 1 zero in window, shrink from left
            if (zeroCount > 1) {
                // Remove leftmost element from window
                // If it was a zero, decrement zero count
                zeroCount -= nums[left] ^ 1;
                left++;
            }
        }

        // Maximum window size is from left pointer to end of array
        return nums.length - left;
    }

    public int findMaxConsecutiveOnesLocal(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            if (zeroCount > 1) {
                max = Math.max(i - left, max);
                left = i;
                zeroCount--;
            }

            if (i == nums.length - 1) {
                max = Math.max(i - left, max);
            }


        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 0, 0, 1};
        int res0, res1;
        MaxConsecutiveArray maxConsecutiveArray = new MaxConsecutiveArray();
        res0 = maxConsecutiveArray.findMaxConsecutiveOnes(nums);
        res1 = maxConsecutiveArray.findMaxConsecutiveOnesLocal(nums);
        System.out.println(String.format("res0=%d, res1=%d", res0, res1));
    }
}
