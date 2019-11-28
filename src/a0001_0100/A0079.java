package a0001_0100;

public class A0079 {
    class Solution {

        // x 轴 和 y 轴的路径
        private int[] x = {1, -1, 0, 0}, y = {0, 0, 1, -1};
        private char[] c[], chs;
        private boolean dfs(int i, int j, int level) {
            // 把这次的直接设为 '#' 防止走回头路
            if (level == chs.length - 1) return true;
            for (int k = 0; k < 4; k++) {
                int tx = i + x[k], ty = j + y[k];
                if (tx > -1 && tx < c.length && ty > -1 && ty < c[0].length && c[tx][ty] == chs[level + 1]) {
                    char old = c[i][j];
                    c[i][j] = '#';
                    if (dfs(tx, ty, level + 1)) return true;
                    c[i][j] = old;
                }
            }
            return false;
        }
        public boolean exist(char[][] a, String s) {
            c = a;
            chs = s.toCharArray();
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == chs[0]) {
                        if (dfs(i, j, 0)) return true;
                    }
                }
            }
            return false;
        }
    }
}
