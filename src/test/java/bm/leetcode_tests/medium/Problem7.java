package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7 {

    @Test
    void example1() {
        Assertions.assertEquals(321, reverse(123));
    }

    @Test
    void example2() {
        Assertions.assertEquals(21, reverse(120));
    }

    public int reverse(int x) {
        int reversed = reverse2(x);
        int reversed2 = reverse2(reversed);
        return reversed2 != x && x % 10 != 0 ? 0 : reversed;
    }

    private int reverse2(int n) {
        int result = 0;
        while (n !=  0) {
            result = (result * 10) + (n % 10);
            n /= 10;
        }
        return result;
    }
}