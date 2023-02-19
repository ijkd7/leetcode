package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem724 {

    @Test
    void example1() {
        var nums = new int[]{1,7,3,6,5,6};
        Assertions.assertEquals(3, pivotIndex(nums));
    }

    @Test
    void example2() {
        var nums = new int[]{1,2,3};
        Assertions.assertEquals(-1, pivotIndex(nums));
    }

    @Test
    void example3() {
        var nums = new int[]{2,1,-1};
        Assertions.assertEquals(0, pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        var sum = 0;
        var left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (left == sum - nums[i] - left) {
                return i;
            } else {
                left += nums[i];
            }
        }

        return -1;
    }

}
