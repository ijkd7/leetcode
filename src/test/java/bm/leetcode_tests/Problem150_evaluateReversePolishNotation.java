package bm.leetcode_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Problem150_evaluateReversePolishNotation {

    @Test
    void example1() {
        Assertions.assertEquals(9, evalRPN(new String[] {"2","1","+","3","*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            switch (s) {
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    st.push(-st.pop() + st.pop());
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    var num2 = st.pop();
                    var num1 = st.pop();
                    st.push(num1/ num2);
                    break;
                default:
                    st.push(Integer.parseInt(s));
                    break;
            }
        }
        return st.pop();
    }

}
