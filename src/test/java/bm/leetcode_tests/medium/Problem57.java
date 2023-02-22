package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem57 {


    @Test
    void example1() {
        var input = new int[][]{{1,3}, {6,9}};
        var interval = new int[]{2,5};
        var res = insert(input, interval);
        var expected = new int[][]{{1,5}, {6,9}};
        Assertions.assertEquals(expected.length, res.length);
        for (int i = 0; i < res.length; i++) {
            Assertions.assertArrayEquals(expected[i], res[i]);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return (result.toArray(new int[][] {}));
            }
            if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        result.add(newInterval);

        return result.toArray(new int[][] {});
    }

}
