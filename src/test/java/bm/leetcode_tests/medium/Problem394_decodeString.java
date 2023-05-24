package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Collectors;

class Problem394_decodeString {

    @Test
    void example1() {
        Assertions.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    }

    @Test
    void example2() {
        Assertions.assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                // finding substring inside [ and ]
                StringBuilder builder = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    builder.insert(0, stack.pop());
                }
                String subStr = builder.toString();
                stack.pop(); //pop "["

                // finding number of times to repeat substring
                builder = new StringBuilder();
                while (!stack.isEmpty() && stack.peek().chars().allMatch(Character::isDigit)) {
                    builder.insert(0, stack.pop());
                }

                int number = Integer.parseInt(builder.toString());
                for (int j = 0; j < number; j++) {
                    stack.push(subStr);
                }
            }
        }
        return String.join("", stack);
    }

}
