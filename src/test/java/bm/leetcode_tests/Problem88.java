package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem88 {

    @Test
    void example1() {
        var nums1 = new int[]{1, 2, 3, 0, 0, 0};
        var nums2 = new int[]{2, 5, 6};
        var res = new int[]{1, 2, 2, 3, 5, 6};
        merge(nums1, 3, nums2, 3);
        Assertions.assertArrayEquals(res, nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var vacant = nums1.length - 1;
        m--;
        n--;

        while (n >= 0 || m >= 0) {
            if (n == -1 || (m != -1 && nums1[m] > nums2[n])) {
                nums1[vacant--] = nums1[m--];
            } else {
                nums1[vacant--] = nums2[n--];
            }
        }
    }

}
