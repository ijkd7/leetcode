package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem62 {

    @Test
    void example1() {
        var m = 3;
        var n = 7;
        Assertions.assertEquals(28, uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        var matrix = new int[m][n];

        Arrays.fill(matrix[0], 1);

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }

        return matrix[m - 1][n - 1];
    }

}
