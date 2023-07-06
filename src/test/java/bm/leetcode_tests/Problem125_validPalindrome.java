package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem125_validPalindrome {

    @Test
    void example1() {
        var s = "A man, a plan, a canal: Panama";
        Assertions.assertTrue(isPalindrome(s));
    }
    @Test
    void example11() {
        var s = "0P";
        Assertions.assertFalse(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        var str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (!Character.isLetterOrDigit(charLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(charRight)) {
                right--;
            } else {
                if (Character.toLowerCase(charLeft) != Character.toLowerCase(charRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

}
