package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Problem150_minStack {

    @Test
    void example1() {
        MinStack obj = new MinStack();
        obj.push(-1);
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        Assertions.assertEquals(-1, param_4);
    }

    class MinStack {
        private Stack<Integer> st = new Stack<>();
        private Stack<Integer> mins = new Stack<>();

        public void push(int val) {
            st.push(val);
            mins.push(Math.min(val, mins.isEmpty() ? val : mins.peek()));
        }

        public void pop() {
            st.pop();
            mins.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }

}
