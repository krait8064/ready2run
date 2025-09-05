package org.example.algorithm.array_and_strings;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefixLocal(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int maxLength = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            String common = strs[0].substring(0, i + 1);
            boolean notCommon = false;
            for (String str : strs) {
                if (!str.substring(0, i + 1).equals(common)) {
                    notCommon = true;
                    break;
                }
            }
            if (notCommon) {
                break;
            } else {
                maxLength += 1;
            }
        }

        return strs[0].substring(0, maxLength);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()) - 1; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefixLocal(new String[]{"flower", "flow", "flight"});
        Assert.assertEquals("fl", s);
        s = longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assert.assertEquals("fl", s);

    }

}
