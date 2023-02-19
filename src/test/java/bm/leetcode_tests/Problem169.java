package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem169 {

    @Test
    void example2() {
        var nums = new int[]{3,2,3};
        Assertions.assertEquals(3, majorityElement(nums));
    }

    @Test
    void example1() {
        var nums = new int[]{2,2,1,1,1,2,2};
        Assertions.assertEquals(2, majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }
            count = count + (nums[i] == res ? 1 : -1);
        }
        return res;
    }

}
