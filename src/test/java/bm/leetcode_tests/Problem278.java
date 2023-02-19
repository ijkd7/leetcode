package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem278 {

    private int ans;

    @Test
    void example1() {
        ans = 1;
        Assertions.assertEquals(1, firstBadVersion(5));
    }

    @Test
    void example11() {
        ans = 1702766719;
        Assertions.assertEquals(1702766719, firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        var left = 1;
        var right = n;
        var middle = 0;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version) {
        return version >= ans;
    }

}
