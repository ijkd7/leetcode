package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Problem560_subarraySumEqualsK {

    @Test
    void example1() {
        var in = new int[]{1,1,1};
        Assertions.assertEquals(2, subarraySum(in, 2));

    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixes = new HashMap<>();
        prefixes.put(0, 1);
        var result = 0;
        var curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            var dif = curSum - k;
            result += prefixes.getOrDefault(dif, 0);
            prefixes.compute(curSum, (key, val) -> val != null ? ++val : 1);
        }
        return result;
    }

}
