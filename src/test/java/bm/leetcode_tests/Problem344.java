package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class Problem344 {

    @Test
    void example1() {
        var input = new char[]{'H','e','l','l','o'};
        var output = new char[]{'o','l','l','e','H'};
        Assertions.assertArrayEquals(output, reverseString(input));
    }

    public char[] reverseString(char[] s) {
        for (int i=0; i<s.length/2; i++) {
            var tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
        return s;
    }
}
