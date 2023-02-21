package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem45 {


    @Test
    void example1() {
        var input = new int[]{2,3,1,1,4};
        Assertions.assertEquals(2, jump(input));
    }

    public int jump(int[] nums) {
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

        return dp[nums.length - 1];
    }

}
