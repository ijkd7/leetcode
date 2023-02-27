package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem128_longestConsecutiveSequence {

    @Test
    void example1() {
        var input = new int[]{100,4,200,1,3,2};
        Assertions.assertEquals(4, longestConsecutive(input));
    }

    public int longestConsecutive(int[] nums) {
        var set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        var result = 0;

        for (int n : nums) {
            var tmpLongest = 0;
            if (!set.contains(n - 1)) { // looking for a sequence start
                while(set.contains(n + tmpLongest)) {
                    tmpLongest++;
                }
            result = Math.max(result, tmpLongest);
            }
        }
        return result;
    }

}
