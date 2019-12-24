package a0301_0400;

public class A0338 {
    // bitCount 算法 分治 法 (count & x + count >> 1 &x)
    // 计算 的 原先 两位 中 1 的 个数
    // --> 计算得原先 4 位 中 1 的 个数
    class Solution {
        private int m1 = ((0x5555 << 16) | 0x5555);
        private int m2 = ((0x3333 << 16) | 0x3333);
        private int m3 = ((0x0f0f << 16) | 0x0f0f);
        private int m4 = ((0x00ff << 16) | 0x00ff);
        private int m5 = 0x0000ffff;
        private int cnt(int a) {
            a = (a & m1) + ((a >> 1) & m1);
            a = (a & m2) + ((a >> 2) & m2);
            a = (a & m3) + ((a >> 4) & m3);
            a = (a & m4) + ((a >> 8) & m4);
            a = (a & m5) + ((a >> 16) & m5);
            return a;
        }
        public int[] countBits(int num) {
            int[] res = new int[num + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = cnt(i);
            }
            return res;
        }
    }
}
