package a1201_1300;

public class A1254 {
    class Solution {
        private boolean[][] vis;
        private int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};

        private void dfs(int[][] a, int i, int j) {
            vis[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int tx = i + x[k], ty = j + y[k];
                if (tx > -1 && tx < a.length
                        && ty > -1 && ty < a[0].length
                        && !vis[tx][ty] && a[tx][ty] == 0) {
                    dfs(a, tx, ty);
                }
            }
        }
        public int closedIsland(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            vis = new boolean[grid.length][grid[0].length];
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][0] == 0 && !vis[i][0]) dfs(grid, i, 0);
                if (grid[i][grid[0].length - 1] == 0 && !vis[i][grid[0].length - 1]) dfs(grid, i, grid[0].length - 1);
            }
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[0][i] == 0 && !vis[0][i]) dfs(grid, 0, i);
                if (grid[grid.length - 1][i] == 0 && !vis[grid.length - 1][i]) dfs(grid, grid.length - 1, i);
            }
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[0].length - 1; j++) {
                    if (!vis[i][j] && grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }
    }
}
