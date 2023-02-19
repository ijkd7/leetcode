package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Problem977 {

    @Test
    void example1() {
        var input = new int[]{-4,-1,0,3,10};
        Assertions.assertArrayEquals(new int[]{0,1,9,16,100}, sortedSquares(input));
    }

    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int current = nums.length - 1;
        var res = new int[nums.length];
        while (l <= r) {
            if (nums[r] * nums[r] > nums[l] * nums[l]) {
                res[current] = nums[r] * nums[r];
                r--;
            } else {
                res[current] = nums[l] * nums[l];
                l++;
            }
            current--;
        }
        return res;
    }
}
