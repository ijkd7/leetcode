package bm.leetcode_tests.medium;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class Problem49_groupAnagrams {

    @Test
    void example1() {
        var strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Assertions.assertEquals(List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat")), groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1 && strs[0].length() < 2) {
            return List.of((List.of(strs[0])));
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
