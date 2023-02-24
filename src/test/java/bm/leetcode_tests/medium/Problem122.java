package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem122 {

    @Test
    void example1() {
        var prices = new int[]{7, 1, 5, 3, 6, 4};
        var res = 7;
        Assertions.assertEquals(res, maxProfit(prices));
    }

    @Test
    void example2() {
        var prices = new int[]{1, 2, 3, 4, 5};
        var res = 4;
        Assertions.assertEquals(res, maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        var profit = 0;
        int bought = -1;

        for (int i = 0; i < prices.length; i++) {
            if (bought == -1 || prices[i] < bought) {
                bought = prices[i];
            } else if (i <= prices.length - 2 && prices[i] > bought && prices[i] > prices[i + 1]) {
                profit += prices[i] - bought;
                bought = -1;
            } else if (i == prices.length - 1 && prices[i] > bought) {
                profit += prices[i] - bought;
                bought = -1;
            }
        }

        return profit;
    }

}
