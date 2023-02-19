package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.util.ArrayStack;

import java.util.LinkedList;
import java.util.Stack;

class Problem66 {

    @Test
    void example1() {
        var input = new int[]{1, 2, 3};
        var output = new int[]{1, 2, 4};
        Assertions.assertArrayEquals(output, plusOne(input));
    }

    @Test
    void example2() {
        var input = new int[]{9};
        var output = new int[]{1, 0};
        Assertions.assertArrayEquals(output, plusOne(input));
    }

    @Test
    void example3() {
        var input = new int[]{1, 9, 9};
        var output = new int[]{2, 0, 0};
        Assertions.assertArrayEquals(output, plusOne(input));
    }

    public int[] plusOne(int[] digits) {
        var length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;

        }

        var result = new int[length + 1];
        result[0] = 1;
        return result;
    }

    public int[] plusOne2(int[] digits) {
        var list = new LinkedList<>();
        var addOne = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (addOne) {
                if (digits[i] == 9) {
                    list.add(0);
                    if (i == 0) {
                        list.add(1);
                    }
                } else {
                    list.add(digits[i] + 1);
                    addOne = false;
                }
            } else {
                list.add(digits[i]);
            }
        }

        var result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) list.removeLast();
        }
        return result;
    }
}
