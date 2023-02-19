package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem35 {

    @Test
    void example1() {
        var nums = new int[]{1, 3, 5, 6};
        var target = 5;
        Assertions.assertEquals(2, searchInsert(nums, target));
    }

    @Test
    void example2() {
        var nums = new int[]{1, 3, 5, 6, 9};
        var target = 6;
        Assertions.assertEquals(3, searchInsert(nums, target));
    }

    @Test
    void example3() {
        var nums = new int[]{1, 3, 5, 6, 9};
        var target = 2;
        Assertions.assertEquals(1, searchInsert(nums, target));
    }

    @Test
    void example4() {
        var nums = new int[]{1, 3, 5, 6};
        var target = 7;
        Assertions.assertEquals(4, searchInsert(nums, target));
    }

    @Test
    void example5() {
        var nums = new int[]{1, 3, 5, 6};
        var target = -7;
        Assertions.assertEquals(0, searchInsert(nums, target));
    }

    @Test
    void example6() {
        var nums = new int[]{1};
        var target = 0;
        Assertions.assertEquals(0, searchInsert(nums, target));
    }

    @Test
    void example7() {
        var nums = new int[]{1, 3};
        var target = 0;
        Assertions.assertEquals(0, searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
