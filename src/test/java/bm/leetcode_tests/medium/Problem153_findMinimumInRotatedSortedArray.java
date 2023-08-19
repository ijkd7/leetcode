package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem153_findMinimumInRotatedSortedArray {

    @Test
    void example1() {
        Assertions.assertEquals(3, findMin(new int[]{3, 6, 7, 11}));
    }

    public int findMin(int[] nums) {
        int min = nums[0];

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }
            int mid = (l + r) / 2;
            min = Math.min(min, mid);

            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return min;
    }

}
