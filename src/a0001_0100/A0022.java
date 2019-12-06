package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0022 {
    class Solution {
        private List<String> res = new ArrayList<>();

        private int n;

        private void dfs(StringBuilder sb, int x, int y) {
            if (sb.length() == 2 * n) {
                if (x == y && x == n) res.add(sb.toString());
                return;
            }
            int len = x + y;
            sb.append('(');
            dfs(sb, x + 1, y);
            sb.setLength(len);
            if (x > y) {
                sb.append(')');
                dfs(sb, x, y + 1);
                sb.setLength(len);
            }
        }

        public List<String> generateParenthesis(int n) {
            this.n = n;
            dfs(new StringBuilder(), 0, 0);
            return res;
        }
    }
}
