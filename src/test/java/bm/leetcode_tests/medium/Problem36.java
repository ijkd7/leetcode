package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Problem36 {


    @Test
    void example1() {
        var board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assertions.assertTrue(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        var set = new HashSet<Character>();

        // check rows
        for (char[] row : board) {
            set.clear();
            for (char c : row) {
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }

        // check columns
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                var cur = board[j][i];
                if (cur != '.') {
                    if (set.contains(cur)) {
                        return false;
                    } else {
                        set.add(cur);
                    }
                }
            }
        }

        // check sections
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set.clear();
                if (putToMap(board[i][j], set)) return false;
                if (putToMap(board[i][j + 1], set)) return false;
                if (putToMap(board[i][j + 2], set)) return false;
                if (putToMap(board[i + 1][j], set)) return false;
                if (putToMap(board[i + 1][j + 1], set)) return false;
                if (putToMap(board[i + 1][j + 2], set)) return false;
                if (putToMap(board[i + 2][j], set)) return false;
                if (putToMap(board[i + 2][j + 1], set)) return false;
                if (putToMap(board[i + 2][j + 2], set)) return false;
            }
        }
        return true;
    }

    private boolean putToMap(char current, HashSet<Character> set) {
        if (current != '.') {
            if (set.contains(current)) {
                return true;
            } else {
                set.add(current);
            }
        }
        return false;
    }

}
