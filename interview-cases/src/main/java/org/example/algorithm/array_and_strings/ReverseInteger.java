package org.example.algorithm.array_and_strings;

import org.junit.Assert;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 *
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = x < 0;
        String str = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(str).reverse();
        int res = Integer.parseInt(sb.toString());
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        int a = new ReverseInteger().reverse(123);
        Assert.assertEquals(321, a);
        a = new ReverseInteger().reverse(-456);
        Assert.assertEquals(-654, a);
    }
}
