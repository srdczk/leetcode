package a0001_0100;

public class A0052 {
    class Solution {

        private int res = 0, q[];

        private void dfs(int i) {
            if (i == q.length) {
                res++;
                return;
            }
            for (int j = 0; j < q.length; j++) {
                boolean pd = true;
                for (int k = 0; k < i; k++) {
                    // 如果重合或在对角线上面
                    if (q[k] == j || Math.abs(q[k] - j) == Math.abs(i - k)) {
                        pd = false;
                        break;
                    }
                }
                if (pd) {
                    q[i] = j;
                    dfs(i + 1);
                }
            }
        }

        public int totalNQueens(int n) {
            q = new int[n];
            dfs(0);
            return res;
        }
    }
}
