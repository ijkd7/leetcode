package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem1 {

    @Test
    void example1() {
        var input = new int[]{2, 7, 11, 15};
        var target = 9;
        var result = twoSum(input, target);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void example2() {
        var input = new int[]{3, 3};
        var target = 6;
        var result = twoSum(input, target);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var secondValue = target - nums[i];
            if (map.containsKey(secondValue)) {
                return new int[]{map.get(secondValue), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
