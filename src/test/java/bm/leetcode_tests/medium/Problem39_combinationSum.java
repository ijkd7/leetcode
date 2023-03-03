package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Problem39_combinationSum {


    @Test
    void example1() {
        var input = new int[]{2,3,6,7};
        var result = combinationSum(input, 7);
        var expResult = new Integer[][]{{2,2,3},{7}};
        Assertions.assertEquals(expResult.length, result.size());
        for (int i = 0; i < expResult.length; i++) {
            Assertions.assertArrayEquals(expResult[i], result.get(i).toArray());
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new ArrayList<Integer>(), 0, candidates, target, result);
        return result;
    }

    public void dfs(int i, List<Integer> cur, int sum, final int[] candidates,
                    final int target, final List<List<Integer>> result) {
        if (i >= candidates.length || sum > target) {
            return;
        }

        if (sum == target) {
            result.add(cur);
            return;
        }

        var newCur = new ArrayList<>(cur);
        newCur.add(candidates[i]);
        dfs(i, newCur, sum + candidates[i], candidates, target, result);
        dfs(i + 1, cur, sum, candidates, target, result);
    }

}
