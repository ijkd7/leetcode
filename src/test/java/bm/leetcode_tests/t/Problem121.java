package bm.leetcode_tests.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem121 {

    @Test
    void example2() {
        var prices = new int[]{7, 6, 4, 3, 1};
        Assertions.assertEquals(0, maxProfit(prices));
    }

    @Test
    void example1() {
        var prices = new int[]{7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, maxProfit(prices));
    }

    @Test
    void example3() {
        var prices = new int[]{7, 2, 5, 3, 6, 1};
        Assertions.assertEquals(4, maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        var buy = prices[0];
        var profit = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

}
