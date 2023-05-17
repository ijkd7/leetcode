package bm.inter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class Problem435_nonOverlappingIntervals {

    @Test
    void example1() {
        var in = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Assertions.assertEquals(1, eraseOverlapIntervals(in));

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        int result = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart >= prevEnd) {
                prevEnd = curEnd;
            } else {
                result++;
                prevEnd = Math.min(prevEnd, curEnd);
            }
        }

        return result;
    }

}
