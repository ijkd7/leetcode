package bm.inter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem238_productOfArrayExceptSelf {

    @Test
    void example1() {
        var nums = new int[]{1, 2, 3, 4};
        var res = new int[]{24, 12, 8, 6};
        Assertions.assertArrayEquals(res, productExceptSelf(nums));
    }

    public int[] productExceptSelf(int[] nums) {
        var res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        var right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right = nums[i + 1] * right;
            res[i] = res[i] * right;
        }

        return res;
    }
}
