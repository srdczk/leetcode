package a0201_0300;

public class A0224 {
    // 表达式求值的实现, 用递归方法, 连带有乘除的一起实现, 227 题也是一样的解法
    // 一个表达式, 可以分解为多个 fac 的和或差, 一个factor, 可以分解成多个 , 一个, 可以是一个表达式 或者是一个 数
    class Solution {
        private char[] chs;
        private int i = 0;

        private int exp() {
            int res = fac();
            while (i < chs.length) {
                if (chs[i] == '+') {
                    i++;
                    res += fac();
                } else if (chs[i] == '-') {
                    i++;
                    res -= fac();
                } else break;
            }
            return res;
        }

        private int fac() {
            int res = num();
            while (i < chs.length) {
                if (chs[i] == '*') {
                    i++;
                    res *= num();
                } else if (chs[i] == '/') {
                    i++;
                    res /= num();
                } else break;
            }
            return res;
        }

        private int num() {
            if (chs[i] == '(') {
                i++;
                int res = exp();
                i++;
                return res;
            } else {
                int res = 0;
                while (i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
                    res = res * 10 + chs[i++] - '0';
                }
                return res;
            }
        }

        public int calculate(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != ' ') sb.append(c);
            }
            chs = sb.toString().toCharArray();
            return exp();
        }
    }
}
