package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem26 {

    @Test
    void example1() {
        var nums = new int[]{1, 1, 2};
        var filteredNums = new int[]{1, 2, 2};
        var answer = 2;
        Assertions.assertEquals(answer, removeDuplicates(nums));
        Assertions.assertArrayEquals(filteredNums, nums);
    }

    @Test
    void example2() {
        var nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        var filteredNums = new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4};
        var answer = 5;
        Assertions.assertEquals(answer, removeDuplicates(nums));
        Assertions.assertArrayEquals(filteredNums, nums);
    }

    public int removeDuplicates(int[] nums) {
        int pointer = 1; //current vacant
        var current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != current) {
                nums[pointer] = nums[i];
                current = nums[i];
                pointer++;
            }
        }
        return pointer;
    }

}
