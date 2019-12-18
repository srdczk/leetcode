package a0801_0900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class A0827 {
    class Solution {
        private int[][] a;
        private HashMap<Integer, Integer> map = new HashMap<>();
        private int cntArea = 0, cnt = 1, x[] = {0, 0, 1, -1}, y[] = {1, -1, 0, 0};
        private void dfs(int i, int j, int[][] grid) {
            cntArea++;
            a[i][j] = cnt;
            for (int k = 0; k < 4; k++) {
                int tx = x[k] + i, ty = y[k] + j;
                if (tx > -1 && tx < a.length && ty > -1 && ty < a[0].length && a[tx][ty] == 0 && grid[tx][ty] == 1) {
                    dfs(tx, ty, grid);
                }
            }
        }
        public int largestIsland(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            a = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && a[i][j] == 0) {
                        cntArea = 0;
                        dfs(i, j, grid);
                        map.put(cnt++, cntArea);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        int p = 1;
                        Set<Integer> set = new HashSet<>();
                        for (int k = 0; k < 4; k++) {
                            int tx = i + x[k], ty = j + y[k];
                            if (tx > -1 && tx < a.length && ty > -1 && ty < a[0].length && a[tx][ty] != 0) {
                                if (!set.contains(a[tx][ty])) p += map.get(a[tx][ty]);
                                set.add(a[tx][ty]);
                            }
                        }
                        res = Math.max(res, p);
                    }
                }
            }
            return res == 0 ? a.length * a[0].length : res;
        }
    }
}
