package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Problem75_sortColors {


    @Test
    void example1() {
        var in = new int[]{2,0,2,1,1,0};
        var out = new int[]{0,0,1,1,2,2};
        Assertions.assertArrayEquals(out, sortColors(in));

    }

    public int[] sortColors(int[] nums) {
        var i = 0;
        var l = 0;
        var r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                var tmp = nums[l];
                nums[l] = nums[i];
                nums[i] = tmp;
                l++;
                i++;
            } else if (nums[i] == 2) {
                var tmp = nums[r];
                nums[r] = nums[i];
                nums[i] = tmp;
                r--;
            } else {
                i++;
            }
        }

        return nums;
    }

}
