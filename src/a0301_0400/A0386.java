package a0301_0400;

import java.util.ArrayList;
import java.util.List;

public class A0386 {
    class Solution {
        private List<Integer> res = new ArrayList<>();

        private int n;

        private void dfs(int i) {
            if (i > n) return;
            res.add(i);
            if (i * 10 < n + 1) dfs(i * 10);
            if (i % 10 != 9) dfs(i + 1);
        }

        public List<Integer> lexicalOrder(int n) {
            this.n = n;
            dfs(1);
            return res;
        }
    }
}
