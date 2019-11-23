package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0077 {
    class Solution {

        private int N, K;

        private List<List<Integer>> res = new ArrayList<>();

        private void dfs(List<Integer> list, int level) {
            if (list.size() == K) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = level; i < N + 1; i++) {
                list.add(i);
                dfs(list, i + 1);
                list.remove(list.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            N = n;
            K = k;
            dfs(new ArrayList<>(), 1);
            return res;
        }
    }
}
