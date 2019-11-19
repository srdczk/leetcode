package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0051 {
    class Solution {

        private List<List<String>> res = new ArrayList<>();

        private int[] q;

        private List<String> toList() {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < q.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < q.length; j++) {
                    if (q[i] == j) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            return list;
        }

        private void dfs(int i) {
            if (i == q.length) {
                res.add(toList());
                return;
            }
            // 试探 0 - n 所有的位置
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

        public List<List<String>> solveNQueens(int n) {
            q = new int[n];
            dfs(0);
            return res;
        }
    }
}
