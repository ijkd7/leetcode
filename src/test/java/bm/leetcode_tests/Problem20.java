package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Stream;

class Problem20 {

    @Test
    void example1() {
        var s = "{}()[]";
        Assertions.assertTrue(isValid(s));
    }

    @Test
    void example4() {
        var s = "{[]}()";
        Assertions.assertTrue(isValid(s));
    }

    @Test
    void example2() {
        var s = "{}()[](";
        Assertions.assertFalse(isValid(s));
    }

    @Test
    void example3() {
        var s = "(]";
        Assertions.assertFalse(isValid(s));
    }

    @Test
    void example5() {
        var s = "]";
        Assertions.assertFalse(isValid(s));
    }

    public boolean isValid(String s) {
        var map = Map.of('}', '{', ']', '[', ')', '(');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.add(c);
            } else if (!stack.isEmpty() && map.containsKey(c) && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
