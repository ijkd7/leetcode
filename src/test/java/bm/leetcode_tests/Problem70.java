package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem70 {

    @Test
    void example1() {
        Assertions.assertEquals(5, climbStairs(4));
    }
// 0 1 2 3 5 8 13
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        var prev = 2;
        var prevPrev = 1;

        for (int i = 3; i <= n; i++) {
            var newPrev = prev + prevPrev;
            prevPrev = prev;
            prev = newPrev;
        }

        return prev;
    }

}
