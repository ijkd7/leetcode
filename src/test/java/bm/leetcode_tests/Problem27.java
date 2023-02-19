package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem27 {

    @Test
    void example1() {
        var nums = new int[]{3, 2, 2, 3};
        var val = 3;
        var filteredNums = new int[]{2, 2, 2, 3};
        var answer = 2;
        Assertions.assertEquals(answer, removeElement(nums, val));
        Assertions.assertArrayEquals(filteredNums, nums);
    }

    public int removeElement(int[] nums, int val) {
        var pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }

}
