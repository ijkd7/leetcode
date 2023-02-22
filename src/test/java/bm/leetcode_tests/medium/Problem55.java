package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

class Problem55 {


    @Test
    void example1() {
        var input = new int[]{2, 3, 1, 1, 4};
        Assertions.assertEquals(true, canJump(input));
    }

    @Test
    void example2() {
        var input = new int[]{3, 2, 1, 0, 4};
        Assertions.assertEquals(false, canJump(input));
    }

    @Test
    void example3() {
        var input = new int[]{0, 2, 3};
        Assertions.assertEquals(false, canJump(input));
    }

    public boolean canJump(int[] nums) {
        var dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < nums.length) {
                        dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                    }
                }
            }
        }

        return dp[nums.length - 1] != Integer.MAX_VALUE;
    }

}
