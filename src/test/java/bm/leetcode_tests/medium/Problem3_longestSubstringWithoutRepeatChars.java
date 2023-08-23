package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Problem3_longestSubstringWithoutRepeatChars {

    @Test
    void example1() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<>();
        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            while (!set.add(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
