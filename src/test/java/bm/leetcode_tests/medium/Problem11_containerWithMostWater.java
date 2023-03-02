package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem11_containerWithMostWater {


    @Test
    void example1() {
        var in = new int[]{1,8,6,2,5,4,8,3,7};
        Assertions.assertEquals(49, maxArea(in));

    }

    public int maxArea(int[] height) {
        var l = 0;
        var r = height.length - 1;
        var area = 0;

        while (l < r) {
            var curArea = (r - l) * Math.min(height[l], height[r]);
            area = Math.max(area, curArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }

}
