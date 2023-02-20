package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Test;

class Problem0_Test {


    @Test
    void example1() {
        Long qwe = Integer.MAX_VALUE+1L;
        Long qwe2 =(long) Integer.MIN_VALUE;

        System.out.println(qwe.hashCode() == qwe2.hashCode());
    }

}
