package a0201_0300;
// Created by srdczk on 2020/1/16

import java.util.Stack;

public class A0255 {
    class Solution {
        public boolean verifyPreorder(int[] a) {
            // 单调栈
            // 维护一个单调递增的栈
            Stack<Integer> stack = new Stack<>();
            int min = Integer.MIN_VALUE;
            for (int c : a) {
                if (c < min) return false;
                while (!stack.isEmpty() && stack.peek() < c) min = stack.pop();
                stack.push(c);
            }
            return true;
        }
    }
}
