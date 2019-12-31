package a0801_0900;

public class A0886 {
    class Solution {
        private int[] p, f;
        private void init(int n) {
            p = new int[n];
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
                p[i] = -1;
            }
        }
        private int findFather(int i) {
            int k = i;
            while (f[i] != i) i = f[i];
            while (k != i) {
                int tmp = f[k];
                f[k] = i;
                k = tmp;
            }
            return i;
        }
        private boolean isSameFather(int i, int j) {
            return findFather(i) == findFather(j);
        }
        private void union(int i, int j) {
            int fi = findFather(i), fj = findFather(j);
            if (fi != fj) f[fi] = fj;
        }

        public boolean possibleBipartition(int N, int[][] dislikes) {
            init(N);
            for (int[] dis : dislikes) {
                int i = dis[0] - 1, j = dis[1] - 1;
                if (isSameFather(i, j)) return false;
                if (p[i] == -1) p[i] = j;
                else union(p[i], j);
                if (p[j] == -1) p[j] = i;
                else union(p[j], i);
            }
            return true;
        }
    }
}
