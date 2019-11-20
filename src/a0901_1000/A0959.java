package a0901_1000;

import java.util.Stack;

public class A0959 {
    // 将每个小格子, 看成是两块儿, 并查集求解
    class Solution {

        private int[] f;

        private void init() {
            for (int i = 0; i < f.length; i++) {
                f[i] = i;
            }
        }

        private int findFather(int i) {
            Stack<Integer> stack = new Stack<>();
            while (f[i] != i) {
                stack.push(i);
                i = f[i];
            }
            while (!stack.isEmpty()) {
                f[stack.pop()] = i;
            }
            return i;
        }

        private void union(int i, int j) {
            int fi = findFather(i), fj = findFather(j);
            if (fi != fj) f[fi] = fj;
        }

        public int regionsBySlashes(String[] ss) {
            if (ss.length == 0 || ss[0].length() == 0) return 0;

            int size = ss[0].length() * ss.length * 2;
            f = new int[size];
            init();
            for (int i = 0; i < ss.length; i++) {
                char[] chs = ss[i].toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    // 上, 下两块块的编号就是
                    // 2 * (i * chs.length + j)
                    // 2 * (i * chs.length + j) + 1
                    if (chs[j] == ' ') {
                        // 先结合这一块儿的两个, 再把上下左右全都合体
                        union(2 * (i * chs.length + j), 2 * (i * chs.length + j) + 1);
                        // 结合上面的下面
                        if (i > 0) union(2 * (i * chs.length + j), 2 * ((i - 1) * chs.length + j) + 1);
                        // 结合下面的上面
//                        if (i != ss.length - 1) union(2 * (i * chs.length + j) + 1, 2 * ((i + 1) * chs.length) + j);
                        if (j > 0) {
                            // 结合左边的右边
                            if (chs[j - 1] == ' ' || chs[j - 1] == '/') union(2 * (i * chs.length + j), 2 * (i * chs.length + (j - 1)) + 1);
                            else union(2 * (i * chs.length + j), 2 * (i * chs.length + (j - 1)));
                        }
//                        if (j != chs.length - 1) {
//                            // 结合右边的左边
//                            if (chs[j + 1] == ' ' || chs[j + 1] == '/') union(2 * (i * chs.length + j), 2 * (i * chs.length + (j + 1)));
//                            else union(2 * (i * chs.length + j), 2 * (i * chs.length + (j + 1)) + 1);
//                        }
                    } else if (chs[j] == '/') {
                        // 上块结合左上, 下块结合右下
                        // 左右的话得情况讨论
                        // 判断左右分别是啥
                        if (i > 0) union(2 * (i * chs.length + j), 2 * ((i - 1) * chs.length + j) + 1);
//                        if (i != ss.length - 1) union(2 * (i * chs.length + j) + 1, 2 * ((i + 1) * chs.length + j));
                        if (j > 0) {
                            if (chs[j - 1] == ' ' || chs[j - 1] == '/') union(2 * (i * chs.length + j), 2 * (i * chs.length + j - 1) + 1);
                            else union(2 * (i * chs.length + j), 2 * (i * chs.length + j - 1));
                        }
//                        if (j != chs.length - 1) {
//                            if (chs[j + 1] == ' ' || chs[j + 1] == '/') union(2 * (i * chs.length + j) + 1, 2 * (i * chs.length + (j + 1)));
//                            else union(2 * (i * chs.length + j) + 1, 2 * (i * chs.length + (j + 1)) + 1);
//                        }
                    } else {
                        // 上块结合右上, 下块结合左下
                        if (i > 0) union(2 * (i * chs.length + j), 2 * ((i - 1) * chs.length + j) + 1);
//                        if (i != ss.length - 1) union(2 * (i * chs.length + j) + 1, 2 * ((i + 1) * chs.length + j));
                        if (j > 0) {
                            if (chs[j - 1] == ' ' || chs[j - 1] == '/') union(2 * (i * chs.length + j) + 1, 2 * (i * chs.length + j - 1) + 1);
                            else union(2 * (i * chs.length + j) + 1, 2 * (i * chs.length + j - 1));
                        }
//                        if (j != chs.length - 1) {
//                            if (chs[j + 1] == ' ' || chs[j + 1] == '/') union(2 * (i * chs.length + j), 2 * (i * chs.length + (j + 1)));
//                            else union(2 * (i * chs.length + j), 2 * (i * chs.length + (j + 1)) + 1);
//                        }
                    }
                }
            }
            int res = 0;
            int[] cnt = new int[size];
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[findFather(i)]++ == 0) res++;
            }
            return res;
        }
    }
}
