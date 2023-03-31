package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Problem525_contiguousArray {

    @Test
    void example1() {
        var in = new int[]{0,1,0};
        Assertions.assertEquals(2, findMaxLength(in));

    }

    public int findMaxLength(int[] nums) {
        var lengths = new HashMap<Integer, Integer>();
        lengths.put(0, -1);
        var maxLen = 0;
        var count = 0;

        for (int i = 0; i <nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;

            if (lengths.containsKey(count)) {
                maxLen = Math.max(maxLen, i - lengths.get(count));
            } else {
                lengths.put(count, i);
            }
        }
        return maxLen;
    }

}
