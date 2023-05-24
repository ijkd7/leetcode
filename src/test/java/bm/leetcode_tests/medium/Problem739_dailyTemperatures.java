package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Problem739_dailyTemperatures {

    @Test
    void example1() {
        Assertions.assertArrayEquals(
                                  new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})
        );
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int curr = 0; curr < temperatures.length; curr++) {
            while (!stack.isEmpty() && temperatures[curr] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = curr - prev;
            }
            stack.add(curr);
        }
        return result;
    }

}
