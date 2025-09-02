package org.example.algorithm.array_and_strings;

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
        int maxSum =0;
        for (int i = 0; i < k; i++) {
            maxSum +=arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            int cur =maxSum+arr[i]-arr[i-k];
            if (cur > maxSum) {
                maxSum = cur;
            }
        }
        return (float)maxSum/k;
    }

    public static void main(String[] args) {
        MaxAverageSubArray maxAverageSubArray = new MaxAverageSubArray();
        int[] arr = {1,12,-5,-6,50,3};
        float res = maxAverageSubArray.maxAverage(arr, 4);
        System.out.println(res);
    }
}
