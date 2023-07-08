package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Problem347_topKFrequentElements {

    @Test
    void example1() {
        var nums = new int[]{1, 1, 1, 2, 2, 3};
        Assertions.assertArrayEquals(new int[]{2, 1}, topKFrequent(nums, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        var result = new int[k];
        var countsMap = new HashMap<Integer, Integer>();

        for(int num : nums) {
            countsMap.compute(num, (key, val) -> val == null ? 1 : ++val);
        }

        var queue = new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(countsMap.entrySet());

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }

}
