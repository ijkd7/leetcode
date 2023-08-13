package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem875_kokoEatingBananas {


    @Test
    void example1() {
        Assertions.assertEquals(4, minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = -1;
        for (int p : piles) {
            r = Math.max(r, p);
        }

        while (l < r) {
            int totalH = 0;
            int mid = (l + r) / 2;
            for (int p : piles) {
                totalH += Math.ceil((double) p / mid);
            }

            if (totalH <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

}
