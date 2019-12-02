package a0001_0100;

public class A0028 {
    // KMP 算法, next 数组的求解
    class Solution {
        private int[] getNext(char[] chs) {
            int[] next = new int[chs.length];
            if (chs.length > 0) next[0] = -1;
            if (chs.length > 1) next[1] = 0;
            if (chs.length < 3) return next;
            int i = 2, cnt = 0;
            while (i < next.length) {
                // 递归的方法求解数组
                if (chs[cnt] == chs[i - 1]) next[i++] = ++cnt;
                else if (cnt == 0) next[i++] = 0;
                else cnt = next[cnt];
            }
            return next;
        }
        public int strStr(String x, String y) {
            char[] cx = x.toCharArray(), cy = y.toCharArray();
            int[] next = getNext(cy);
            int i = 0, j = 0;
            while (i < cx.length && j < cy.length) {
                if (cx[i] == cy[j]) {
                    i++;
                    j++;
                } else if (j == 0) i++;
                else j = next[j];
            }
            return j == cy.length ? i - j : -1;
        }
    }
}
