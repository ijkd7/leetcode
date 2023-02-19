package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem283 {

    @Test
    void example1() {
        var in = new int[]{0, 1, 0, 3, 12};
        var out = new int[]{1, 3, 12, 0, 0};
        Assertions.assertArrayEquals(out, moveZeroes(in));
    }

    public int[] moveZeroes(int[] nums) {
        int vacant = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                var tmp = nums[vacant];
                nums[vacant] = nums[i];
                nums[i] = tmp;
                vacant++;
            }
        }
        return nums;
    }

}
