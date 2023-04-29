package bm.leetcode_tests.medium.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem58 {

    @Test
    void example1() {
        var s = "Hello World";
        Assertions.assertEquals(5, lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        var lastSpaceIndex = s.lastIndexOf(" ");
        return s.length() - (lastSpaceIndex + 1);
    }

}
