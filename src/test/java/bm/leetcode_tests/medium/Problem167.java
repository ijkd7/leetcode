package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem167 {

    @Test
    void example2() {
        var nums = new int[]{2,7,11,15};
        Assertions.assertArrayEquals(new int[]{1,2}, twoSum(nums, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return null;
    }

}
