package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Problem853_carFleet {


    @Test
    void example1() {
        Assertions.assertEquals(3, carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        float[] time = new float[target + 1];
        float max = 0;
        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }
        int count = 0;
        for (int i = target; i >= 0; i--) {
            if (time[i] > max) {
                count++;
                max = time[i];
            }
        }
        return count;
    }

}
