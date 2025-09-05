package org.example.algorithm.array_and_strings;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * <p>
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * <p>
 * Output: -1
 */
public class FirstUniqueCharacterInString {

    public int firstUniqCharLocal(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i <= str.length() - 1; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
        String str = "abcdefg";
        int res = firstUniqueCharacterInString.firstUniqCharLocal(str);
        Assert.assertEquals(0, res);
        str = "loveleetcode";
        res = firstUniqueCharacterInString.firstUniqCharLocal(str);
        Assert.assertEquals(2, res);

    }
}
