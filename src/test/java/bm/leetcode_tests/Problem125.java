package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class Problem125 {

    @Test
    void example1() {
        var s = "A man, a plan, a canal: Panama";
        Assertions.assertEquals(true, isPalindrome(s));
    }
    @Test
    void example11() {
        var s = "0P";
        Assertions.assertEquals(false, isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        var str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return new StringBuilder(str).reverse().toString().equals(str);
    }

}
