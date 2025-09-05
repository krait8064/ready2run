package org.example.algorithm.array_and_strings;

import org.junit.Assert;

/**
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
public class MaxAverageSubArray {

    public float maxAverage(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            int cur = maxSum + arr[i] - arr[i - k];
            if (cur > maxSum) {
                maxSum = cur;
            }
        }
        return (float) maxSum / k;
    }

    public float maxAverageLocal(int[] arr, int k) {
        if (k > arr.length) {
            k = k % arr.length;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                max += arr[i];
            } else {
                if (arr[i] > arr[i - k]) {
                    max = Math.max(max, max + arr[i] - arr[i - k]);
                }
            }
        }
        return (float) max / k;
    }

    public static void main(String[] args) {
        MaxAverageSubArray maxAverageSubArray = new MaxAverageSubArray();
        int[] arr = {1, 12, -5, -6, 50, 3};
        float res = maxAverageSubArray.maxAverage(arr, 4);
        Assert.assertEquals(12.75f, res, 0.000001);
        res = maxAverageSubArray.maxAverageLocal(arr, 4);
        Assert.assertEquals(12.75f, res, 0.000001);
    }
}
