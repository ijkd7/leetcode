package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem9 {

    @Test
    void example1() {
        var x = 121;
        Assertions.assertEquals(true, isPalindrome(x));
    }

    @Test
    void example2() {
        var x = 1221;
        Assertions.assertEquals(true, isPalindrome(x));
    }

    @Test
    void example3() {
        var x = 12;
        Assertions.assertEquals(false, isPalindrome(x));
    }

    @Test
    void example4() {
        var x = -11;
        Assertions.assertEquals(false, isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        var s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
