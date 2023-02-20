package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem8 {

    @Test
    void example1() {
        var s = "   -42";
        Assertions.assertEquals(-42, myAtoi(s));
    }

    public int myAtoi(String s) {
        s = s.trim();
        var isNeg = false;
        var result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if ((s.charAt(i) != '-' && s.charAt(i) != '+' && !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                    return 0;
                }
                if (s.charAt(i) == '-') {
                    isNeg = true;
                }
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                var newResult = result * 10 + (s.charAt(i) - '0');
                if (result != newResult / 10) {
                    if (isNeg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                result = newResult;
            } else if (i != 0) {
                break;
            }
        }
        return isNeg ? result * -1 : result;
    }

}
