package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem189 {


    @Test
    void example1() {
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        var res = new int[]{5, 6, 7, 1, 2, 3, 4};
        Assertions.assertArrayEquals(res, rotate(nums, 3));
    }

    public int[] rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        k = k % nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            var tmp = nums [left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }

        left = 0;
        right = k - 1;
        while (left < right) {
            var tmp = nums [left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }

        left = k;
        right = nums.length - 1;
        while (left < right) {
            var tmp = nums [left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }

        return nums;
    }

}
