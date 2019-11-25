package a0101_0200;

public class A0198 {
    class Solution {
        // 不能偷相邻房间的
        public int rob(int[] a) {
            if (a.length < 1) return 0;
            int x = a[0], y = 0, res = a[0];
            for (int i = 1; i < a.length; i++) {
                int tmp = x;
                // x 表示偷上次的最大值
                x = y + a[i];
                y = Math.max(y, tmp);
                res = Math.max(x, Math.max(y, res));
            }
            return res;
        }
    }
}
