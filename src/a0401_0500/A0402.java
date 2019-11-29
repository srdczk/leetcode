package a0401_0500;

import java.util.Stack;

public class A0402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            // 要使得数字最小 <---> 越前面的数字要越小, 用栈来模拟
            Stack<Character> stack = new Stack<>();
            char[] chs = num.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                while (!stack.isEmpty() && stack.peek() > chs[i] && stack.size() + chs.length - i > chs.length - k) stack.pop();
                stack.push(chs[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            sb.setLength(chs.length - k);
            int i = 0;
            while (i < chs.length - k && sb.charAt(i) == '0') i++;
            if (i == chs.length - k) return "0";
            else return sb.substring(i, chs.length - k);
        }
    }
}
