package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Problem22_generateParentheses {


    @Test
    void example1() {
        Assertions.assertEquals(List.of("((()))","(()())","(())()","()(())","()()()"), generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String currentStr, int open, int close, int n) {
        if (currentStr.length() == n * 2) {
            result.add(currentStr);
            return;
        }

        if (open < n) {
            backtrack(result, currentStr + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(result, currentStr + ")", open, close + 1, n);
        }
    }

}
