package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Problem232_queueUsingStack {

    @Test
    void example2() {
        MyQueue obj = new MyQueue();
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        Assertions.assertTrue(param_4);
    }

    class MyQueue {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();

        public void push(int x) {
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            stack.push(x);
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
