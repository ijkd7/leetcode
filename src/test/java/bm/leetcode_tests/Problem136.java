package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem136 {

    @Test
    void example1() {
        var input = new int[]{2,2,1};
        Assertions.assertEquals(1, singleNumber(input));
    }

    public int singleNumber(int[] nums) {

        var result = 0;

        for (int n : nums) {
            result ^= n;
        }

        return result;
    }

}
