package a1001_1100;
// Created by srdczk on 2020/1/7

import java.util.LinkedList;
import java.util.Queue;

public class A1091 {
    class Solution {
        private int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
        private int[] y = {1, -1, 0, 0, -1, 1, -1, 1};
        private int[][] vis;
        private int res(int[][] g) {
            Queue<int[]> queue = new LinkedList<>();
            vis[0][0] = 1;
            queue.offer(new int[] {0, 0});
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                for (int i = 0; i < x.length; i++) {
                    int tx = p[0] + x[i], ty = p[1] + y[i];
                    if (tx > -1 && tx < vis.length
                            && ty > -1 && ty < vis[0].length
                            && vis[tx][ty] == 0 && g[tx][ty] == 0) {
                        if (tx == vis.length - 1 && ty == vis[0].length - 1) {
                            return vis[p[0]][p[1]] + 1;
                        }
                        vis[tx][ty] = vis[p[0]][p[1]] + 1;
                        queue.offer(new int[] {tx, ty});
                    }
                }
            }
            return -1;
        }
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            if (grid[grid.length - 1][grid[0].length - 1] == 1 || grid[0][0] == 1) return -1;
            if (grid.length == 1 && grid[0].length == 1) return 1;
            vis = new int[grid.length][grid[0].length];
            return res(grid);
        }
    }
}
