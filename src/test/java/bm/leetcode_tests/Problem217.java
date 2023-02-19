package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Problem217 {

    @Test
    void example1() {
        var input = new int[]{1,2,3,1};
        Assertions.assertTrue(containsDuplicate(input));
    }

    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
