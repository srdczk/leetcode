package a0601_0700;

public class A0684 {
    class Solution {
        private int[] f;
        private void init(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
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
        private boolean isSame(int i, int j) {
            return findFather(i) == findFather(j);
        }
        private void union(int i, int j) {
            int fi = findFather(i), fj = findFather(j);
            if (fi != fj) f[fi] = fj;
        }
        public int[] findRedundantConnection(int[][] es) {
            init(es.length);
            for (int[] c : es) {
                if (isSame(c[0] - 1, c[1] - 1)) return c;
                union(c[0] - 1, c[1] - 1);
            }
            return null;
        }
    }
}
