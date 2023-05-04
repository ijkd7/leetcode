package bm.leetcode_tests.medium.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1480 {

    @Test
    void example1() {
        var nums = new int[]{1,2,3,4};
        Assertions.assertArrayEquals(new int[]{1,3,6,10}, runningSum(nums));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        return nums;
    }

}
