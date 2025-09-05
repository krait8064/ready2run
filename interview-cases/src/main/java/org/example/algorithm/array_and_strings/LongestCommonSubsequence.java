package org.example.algorithm.array_and_strings;

import org.junit.Assert;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *<a href="https://leetcode.com/problems/longest-common-subsequence/solutions/6027437/video-dynamic-programming-solution/">...</a>
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcd";
        String text2 = "dbca";
        int res = lcs.logestCommonSubsequence(text1, text2);
        Assert.assertEquals(res, 2);
        res = lcs.logestCommonSubsequenceLocal(text1, text2);
        Assert.assertEquals(res, 2);
        text1 = "abcde";
        text2 = "ace";
        int res2 = lcs.logestCommonSubsequence(text1, text2);
        Assert.assertEquals(res2, 3);
        res = lcs.logestCommonSubsequenceLocal(text1, text2);
        Assert.assertEquals(res2, 3);
    }

    public int logestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int longest = 0;

        for (char c : text2.toCharArray()) {
            int curLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (curLength < dp[i]) {
                    curLength = dp[i];
                } else if (c == text1.charAt(i)) {
                    dp[i] = curLength + 1;
                    longest = Math.max(longest, curLength + 1);
                }
            }
        }

        return longest;
    }

    public int logestCommonSubsequenceLocal(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int longest = 0;
        for (char c : text2.toCharArray()) {
            int curLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (curLength < dp[i]) {
                    curLength = dp[i];
                } else if (c == text1.charAt(i)) {
                    dp[i] = curLength + 1;
                    longest = Math.max(longest, curLength + 1);
                }
            }
        }
        return longest;
    }
}
