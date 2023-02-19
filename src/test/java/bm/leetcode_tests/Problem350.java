package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Problem350 {

    @Test
    void example1() {
        var input = new int[]{1, 2, 2, 1};
        var input2 = new int[]{2, 2};
        Assertions.assertArrayEquals(new int[]{2, 2}, intersect(input, input2));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        var res = new ArrayList<Integer>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        return res.stream().mapToInt(n -> n).toArray();

    }

}
