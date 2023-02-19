package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem14 {

    @Test
    void example1() {
        var strs = new String[]{"flower", "flow", "flight"};
        Assertions.assertEquals("fl", longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        var result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result, strs[i]);
        }
        return result;
    }

    private String longestCommonPrefix(String s1, String s2) {
        var length = Math.min(s1.length(), s2.length());
        var result = "";
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                result += s1.charAt(i);
            } else {
                break;
            }
        }
        return result;
    }

}
