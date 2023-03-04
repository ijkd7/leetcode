package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem56_mergeIntervals {


    @Test
    void example1() {
        var in = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        var out = new int[][]{{1,6},{8,10},{15,18}};
        var result = merge(in);
        Assertions.assertEquals(out.length, result.length);
        for (int i = 0; i < out.length; i++) {
            Assertions.assertArrayEquals(out[i], result[i]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        if (intervals.length == 1) {
            return new int[][]{intervals[0]};
        }

        var list = new ArrayList<int[]>();
        var start = intervals[0][0];
        var end = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        list.add(new int[]{start, end});
        return list.toArray(new int[][]{});
    }

}
