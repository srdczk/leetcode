package a0201_0300;

public class A0213 {
    class Solution {
        public int rob(int[] a) {
            // 第一个和最后一个是相邻的, 所以分开讨论
            if (a.length < 2) return a.length == 0 ? 0 : a[0];
            if (a.length == 2) return Math.max(a[0], a[1]);
            if (a.length == 3) return Math.max(a[0], Math.max(a[1], a[2]));
            // 如果偷a[0]
            // a[1] 不考虑, 直接偷到a.length - 2;
            // 如果不偷 a[0] 直接偷到 a.length - 1;
            int res = a[0] + a[2];
            int x = a[0] + a[2], y = a[0];
            for (int i = 3; i < a.length - 1; i++) {
                // 偷了上一个
                int tmp = x;
                // y 没偷上一个
                x = y + a[i];
                y = Math.max(tmp, y);
                res = Math.max(res, Math.max(x, y));
            }
            // 如果没有偷窃 a[0]
            res = Math.max(a[1], res);
            x = a[1];
            y = 0;
            // 可以一直偷到底
            for (int i = 2; i < a.length; i++) {
                int tmp = x;
                // y 没偷上一个
                x = y + a[i];
                y = Math.max(tmp, y);
                res = Math.max(res, Math.max(x, y));
            }
            return res;
        }
    }
}
