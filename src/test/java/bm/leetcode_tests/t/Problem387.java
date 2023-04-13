package bm.leetcode_tests.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

class Problem387 {

    @Test
    void example1() {
        Assertions.assertEquals(0, firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        var map = new LinkedHashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : ++v);
        }

        return map.entrySet().stream().filter(o -> o.getValue() == 1).findFirst().map(o -> s.indexOf(o.getKey())).orElse(-1);
    }
}