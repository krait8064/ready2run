package org.example.algorithm.array_and_strings;

import org.junit.Assert;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * <p>
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class ImplementStrstr {
    public int valid(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String base = str1, sub = str2;
        if (len1 < len2) {
            base = str2;
            sub = str1;
        }

        for (int i = 0; i < base.length(); i++) {
            if (base.startsWith(sub, i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrstr impl = new ImplementStrstr();
        int index = impl.valid("sadbutsad", "sad");
        Assert.assertEquals(index, 0);
        index = impl.valid("leetcode", "leeto");
        Assert.assertEquals(index, -1);
    }
}
