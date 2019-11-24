package a0101_0200;

import java.util.Stack;

public class A0150 {
    class Solution {
        public int evalRPN(String[] ss) {
            Stack<String> stack = new Stack<>();
            for (String s : ss) {
                try {
                    int c = Integer.parseInt(s);
                    stack.push(String.valueOf(c));
                } catch (Exception e) {
                    int a = Integer.parseInt(stack.pop()), b = Integer.parseInt(stack.pop());
                    if (s.equals("+")) {
                        stack.push(String.valueOf(a + b));
                    } else if (s.equals("-")) {
                        stack.push(String.valueOf(b - a));
                    } else if (s.equals("*")) {
                        stack.push(String.valueOf(a * b));
                    } else {
                        stack.push(String.valueOf(b / a));
                    }
                }
            }
            return Integer.parseInt(stack.pop());
        }
    }
}
