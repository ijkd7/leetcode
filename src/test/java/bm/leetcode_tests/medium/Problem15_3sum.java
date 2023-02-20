package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem15_3sum {


    @Test
    void example1() {
        var input = new int[]{-1, 0, 1, 2, -1, -4};
        var out = new Integer[][]{{-1, -1, 2}, {-1, 0, 1}};
        var res = threeSum(input);
        Assertions.assertEquals(out.length, res.size());
        for (int i = 0; i < out.length; i++) {
            Assertions.assertArrayEquals(out[i], res.get(i).toArray());
        }
    }

    @Test
    void example2() {
        var input = new int[]{0,0,0,0};
        var out = new Integer[][]{{0,0,0}};
        var res = threeSum(input);
        Assertions.assertEquals(out.length, res.size());
        for (int i = 0; i < out.length; i++) {
            Assertions.assertArrayEquals(out[i], res.get(i).toArray());
        }
    }

    @Test
    void example3() {
        var input = new int[]{-1,0,1,0};
        var out = new Integer[][]{{-1,0,1}};
        var res = threeSum(input);
        Assertions.assertEquals(out.length, res.size());
        for (int i = 0; i < out.length; i++) {
            Assertions.assertArrayEquals(out[i], res.get(i).toArray());
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Map<Integer, Integer> repetitions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            repetitions.compute(nums[i], (o, val) -> val == null ? 1 : ++val);
            //repetitions.put(nums[i], repetitions.getOrDefault(nums[i], 0) + 1);
        }

        if (repetitions.getOrDefault(0, 0) >= 3) {
            ans.add(List.of(0, 0, 0));
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 3 && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                var expected = -(nums[i] + nums[j]);
                if (expected == nums[i] || expected == nums[j]) {
                    if (repetitions.get(expected) >= 2 && (nums[i] != 0 && nums[j] != 0)) {
                        ans.add(Stream.of(nums[i], nums[j], expected).sorted().toList());
                    }
                } else if (repetitions.containsKey(expected)) {
                    ans.add(Stream.of(nums[i], nums[j], expected).sorted().toList());
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        var sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sortedNums.length; i++) {
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) {
                continue;
            }
            var first = sortedNums[i];

            var l = i + 1;
            var r = sortedNums.length - 1;

            while (l < r) {
                var sum = first + sortedNums[l] + sortedNums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(first, sortedNums[l], sortedNums[r]));
                    ++l;
                    while (l < r && sortedNums[l - 1] == sortedNums[l]) {
                        l++;
                    }
                }
            }

        }

        return result;
    }

}
