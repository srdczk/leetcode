package a0701_0800;

import java.util.ArrayList;
import java.util.List;

public class A0797 {
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private int[][] g;

        private void dfs(int i, List<Integer> list) {
            if (i == g.length - 1) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int c : g[i]) {
                list.add(c);
                dfs(c, list);
                list.remove(list.size() - 1);
            }
        }

        public List<List<Integer>> allPathsSourceTarget(int[][] gd) {
            g = gd;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            dfs(0, list);
            return res;
        }
    }
}
