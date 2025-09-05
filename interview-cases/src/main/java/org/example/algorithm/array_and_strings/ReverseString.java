package org.example.algorithm.array_and_strings;

import org.junit.Assert;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 */
public class ReverseString {
    public char[] reverse(char[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int len = nums.length;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[len - i - 1] = nums[i];
        }
        return res;
    }

    public char[] reverseLocal(char[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i < j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String str = "abcdefg";
        String res = String.valueOf(reverseString.reverse(str.toCharArray()));
        Assert.assertEquals("gfedcba", res);
        str = "hello";
        res = String.valueOf(reverseString.reverse(str.toCharArray()));
        Assert.assertEquals("olleh", res);
    }
}
