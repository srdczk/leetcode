package a0701_0800;

public class A0785 {
    class Solution {
        // 判断二分图, 两边涂不同颜色 dfs
        private int[][] g;
        private int[] c;
        private boolean res = true;
        private void dfs(int i, int k) {
            if (!res) return;
            if (c[i] != 0 && c[i] != k) {
                res = false;
                return;
            }
            c[i] = k;
            for (int s : g[i]) {
                if (c[s] != 0) {
                    if (c[s] != -k) {
                        res = false;
                        return;
                    }
                } else dfs(s, -k);
            }
        }
        public boolean isBipartite(int[][] graph) {
            // graph[i] 表示 i 的所有 邻接点
            // dfs
            g = graph;
            c = new int[graph.length];
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 0) {
                    if (res) dfs(i, 1);
                    else return false;
                }
            }
            return res;
        }
    }
}
