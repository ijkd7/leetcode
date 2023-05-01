package bm.leetcode_tests.medium.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem16_3sumClosest {

    @Test
    void example1() {
        var in = new int[]{-1,2,1,-4};
        Assertions.assertEquals(2, threeSumClosest(in, 1));

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while ( left < right) {
                int curSum = nums[left] + nums[i] + nums[right];
                if(curSum > target) {
                    right--;
                } else {
                    left++;
                }

                if (Math.abs(curSum - target) < Math.abs(result - target)) {
                    result = curSum;
                }
            }
        }

        return result;
    }

}
