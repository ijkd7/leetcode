package bm.leetcode_tests.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem54 {

    int[] dy = new int[]{0, 1, 0, -1}; //row
    int[] dx = new int[]{1, 0, -1, 0}; //col

    @Test
    void example1() {
        var matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        var res = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        Assertions.assertArrayEquals(res.toArray(), spiralOrder(matrix).toArray());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        var result = new ArrayList<Integer>();
        spiralOrderRec(0, 0, 0, matrix, result);
        return result;
    }

    private void spiralOrderRec(int shift, int row, int col, int[][] matrix, List<Integer> result) {
        while (true) {
            if (row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0 || matrix[row][col] == 101) {
                return;
            }

            result.add(matrix[row][col]);
            matrix[row][col] = 101;

            var newRow = row + dy[shift];
            var newCol = col + dx[shift];
            if (newRow >= matrix.length || newCol >= matrix[0].length || newRow < 0 || newCol < 0 || matrix[newRow][newCol] == 101) {
                shift = (shift + 1) % 4;
                newRow = row + dy[shift];
                newCol = col + dx[shift];
            }
            row = newRow;
            col = newCol;
        }
        //spiralOrderRec(shift, newRow, newCol, matrix, result);
    }

}
