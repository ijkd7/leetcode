package bm.leetcode_tests.t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem322 {


    @Test
    void example1() {
        var input = new int[]{1, 2, 5};
        Assertions.assertEquals(3, coinChange(input, 11));
    }

    @Test
    void example2() {
        var input = new int[]{186, 419, 83, 408};
        Assertions.assertEquals(20, coinChange(input, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        var dp = new int[amount + 1];

        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] != 0) {
                for (int coin : coins) {
                    var sum = i + coin;
                    if (sum > 0 && sum <= amount) {
                        if (dp[sum] != 0) {
                            var minAmount = Math.min(dp[sum], dp[i] + 1);
                            dp[sum] = minAmount;
                        } else {
                            dp[sum] = dp[i] + 1;
                        }
                    }
                }
            }
        }

        return dp[amount] != 0 ? dp[amount] : -1;
    }

}
