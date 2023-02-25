package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem134_gasStation {


    @Test
    void example1() {
        var gas = new int[]{1,2,3,4,5};
        var cost = new int[]{3,4,5,1,2};
        Assertions.assertEquals(3, canCompleteCircuit(gas, cost));

    }

    @Test
    void example2() {
        var gas = new int[]{2,3,4};
        var cost = new int[]{3,4,3};
        Assertions.assertEquals(-1, canCompleteCircuit(gas, cost));

    }

    @Test
    void example3() {
        var gas = new int[]{5,1,2,3,4};
        var cost = new int[]{4,4,1,5,1};
        Assertions.assertEquals(4, canCompleteCircuit(gas, cost));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int sum = 0;
        int totalSum = 0;

        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                result = i + 1;
            }
        }

        return totalSum < 0 ? -1 : result;
    }

}
