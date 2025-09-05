package org.example.algorithm.array_and_strings;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "anagram"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * <p>
 * Output: false
 */
public class ValidAnagram {
    public boolean validAnagram(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : s1.toCharArray()) {
            arr[c - 'a'] += 1;
        }
        for (char c : s2.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a'] -= 1;
        }
        return true;

    }

    public boolean validAnagramLocal(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        char[] charArray = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray2);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArray2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "anagram";
        ValidAnagram validAnagram = new ValidAnagram();
        Assert.assertTrue(validAnagram.validAnagram(s1, s2));
        Assert.assertTrue(validAnagram.validAnagramLocal(s1, s2));
        s1 = "rat";
        s2 = "car";
        Assert.assertFalse(validAnagram.validAnagram(s1, s2));
        Assert.assertFalse(validAnagram.validAnagramLocal(s1, s2));
    }


}
