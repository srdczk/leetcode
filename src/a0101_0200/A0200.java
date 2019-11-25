package a0101_0200;

public class A0200 {
    class Solution {
        // 1 代表陆地, 0 代表水
        private char[][] c;
        private int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};
        private void dfs(int i, int j) {
            c[i][j] = '0';
            for (int k = 0; k < 4; k++) {
                int tx = i + x[k], ty = j + y[k];
                if (tx < c.length && tx > -1 && ty < c[0].length && ty > -1 && c[tx][ty] == '1') {
                    dfs(tx, ty);
                }
            }
        }
        public int numIslands(char[][] a) {
            if (a.length == 0 || a[0].length == 0) return 0;
            c = a;
            int res = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == '1') {
                        res++;
                        dfs(i, j);
                    }
                }
            }
            return res;
        }
    }
}
