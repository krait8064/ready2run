package org.example.algorithm.array_and_strings;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        return res;
    }
}
