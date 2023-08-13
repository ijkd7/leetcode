package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem74_search2DMatrix {


    @Test
    void example1() {
        var input = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Assertions.assertTrue(searchMatrix(input, 3));
    }

    @Test
    void example2() {
        var input = new int[][]{{1,1}};
        Assertions.assertFalse(searchMatrix(input, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int size = matrix[0].length * matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = size;

        while (l < r) {
            int mid = (l + r) / 2;
            int i = mid / col;
            int j = mid % col;

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }

}
