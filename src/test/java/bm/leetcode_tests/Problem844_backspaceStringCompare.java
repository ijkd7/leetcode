package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Problem844_backspaceStringCompare {

    @Test
    void example1() {
        Assertions.assertTrue(backspaceCompare("ab#c", "ad#c"));
    }

    @Test
    void example2() {
        Assertions.assertFalse(backspaceCompare("a#c", "b"));
    }

    @Test
    void example3() {
        Assertions.assertTrue(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for(char c : s.toCharArray()) {
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }

        for(char c : t.toCharArray()) {
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }

        return stackS.equals(stackT);
    }

}
