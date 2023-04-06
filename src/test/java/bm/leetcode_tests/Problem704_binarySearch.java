package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem704_binarySearch {

    @Test
    void example1() {
        var in = new int[]{-1,0,3,5,9,12};
        Assertions.assertEquals(4, search(in, 9));

    }

    @Test
    void example2() {
        var in = new int[]{5};
        Assertions.assertEquals(-1, search(in, -5));

    }

    public int search(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;

        while(l <= r) {
            var m = l + ((r - l) / 2);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }

}
