package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Problem454 {

    @Test
    void example1() {
        var nums1 = new int[]{1, 2};
        var nums2 = new int[]{-2, -1};
        var nums3 = new int[]{-1, 2};
        var nums4 = new int[]{0, 2};
        Assertions.assertEquals(2, fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    void example2() {
        var nums1 = new int[]{0};
        var nums2 = new int[]{0};
        var nums3 = new int[]{0};
        var nums4 = new int[]{0};
        Assertions.assertEquals(1, fourSumCount(nums1, nums2, nums3, nums4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        var result = 0;
        var sum12 = new HashMap<Integer, Integer>();

        for (var n1: nums1) {
            for (var n2: nums2) {
                sum12.compute(n1 + n2, (o, count) -> count == null ? 1 : ++count);
            }
        }

        for (var n3: nums3) {
            for (var n4: nums4) {
                result += sum12.getOrDefault(-(n3 + n4), 0);
            }
        }

        return result;
    }

}
