package bm.leetcode_tests.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem48 {

    @Test
    void example1() {
        var matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        var expected = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        rotate(matrix);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], matrix[i]);
        }
    }

    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix.length; col++) {
                var tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length / 2; col++) {
                var tmp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length - 1 - col];
                matrix[row][matrix.length - 1 - col] = tmp;
            }
        }
    }

}
// 0 2 3 4
// 0 0 3 4
// 0 0 0 4
// 0 0 0 0

// 1 2 0 0
// 1 2 0 0
// 1 2 0 0
// 1 2 0 04