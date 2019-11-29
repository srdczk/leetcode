package a0501_0600;

public class A0547 {
    class Solution {
        // 并查集求解
        private int[] f;
        private void init(int n) {
            f = new int[n];
            for (int i = 0; i < f.length; i++) f[i] = i;
        }
        private int findFather(int i) {
            int t = i;
            while (f[i] != i) i = f[i];
            while (t != i) {
                int next = f[t];
                f[t] = i;
                t = next;
            }
            return i;
        }
        private void union(int i, int j) {
            int fi = findFather(i), fj = findFather(j);
            if (fi != fj) {
                f[fi] = fj;
            }
        }
        public int findCircleNum(int[][] m) {
            init(m.length);
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (m[i][j] == 1) union(i, j);
                }
            }
            int cnt[] = new int[m.length], res = 0;
            for (int i = 0; i < m.length; i++) {
                if (cnt[findFather(i)]++ == 0) res++;
            }
            return res;
        }
    }
}
