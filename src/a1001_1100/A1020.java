package a1001_1100;
// Created by srdczk on 2020/1/2

public class A1020 {
    class Solution {
        private int[][] a;
        private boolean[][] vis;
        private int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};
        private void dfs(int i, int j) {
            vis[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int tx = x[k] + i, ty = y[k] + j;
                if (tx > -1 && tx < vis.length && ty > -1 && ty < vis[0].length && !vis[tx][ty] && a[tx][ty] == 1) {
                    dfs(tx, ty);
                }
            }
        }
        public int numEnclaves(int[][] a) {
            int res = 0;
            if (a.length == 0 || a[0].length == 0) return 0;
            vis = new boolean[a.length][a[0].length];
            this.a = a;
            for (int i = 0; i < a.length; i++) {
                if (a[i][0] == 1) dfs(i, 0);
                if (a[i][a[0].length - 1] == 1) dfs(i, a[0].length - 1);
            }
            for (int i = 0; i < a[0].length; i++) {
                if (a[0][i] == 1) dfs(0, i);
                if (a[a.length - 1][i] == 1) dfs(a.length - 1, i);
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == 1 && !vis[i][j]) res++;
                }
            }
            return res;
        }
    }
}
