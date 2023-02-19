package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem202 {

    @Test
    void example1() {
        Assertions.assertEquals(true, isHappy(19));
    }

    @Test
    void example2() {
        Assertions.assertEquals(false, isHappy(2));
    }

    @Test
    void example3() {
        Assertions.assertEquals(true, isHappy(1));
    }

    public boolean isHappy(int n) {
        var repeats = new boolean[731];

        int sum = 0;
        while(true) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
            if (n < 10) {
                sum += Math.pow(n, 2);
            }
            if (n < 10) {
                if (sum == 1) {
                    return true;
                }
                if (!repeats[sum]) {
                    repeats[sum] = true;
                    n = sum;
                    sum = 0;
                } else {
                    break;
                }
            }
        }
        return false;
    }

}
