package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

class Problem242 {

    @Test
    void example1() {
        var s = "anagram";
        var t = "nagaram";
        Assertions.assertEquals(true, isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        var s1 = s.toCharArray();
        Arrays.sort(s1);
        var t1 = t.toCharArray();
        Arrays.sort(t1);
        return Arrays.compare(s1, t1) == 0;
    }

}
