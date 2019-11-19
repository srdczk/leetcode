package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0039 {
    // 求和为 t 的组合, 深度优先搜索....
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private void dfs(List<Integer> list, int[] a, int level, int sum) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = level; i < a.length; i++) {
                if (a[i] <= sum) {
                    list.add(a[i]);
                    dfs(list, a, i, sum - a[i]);
                    list.remove(list.size() - 1);
                }
            }
        }

        public List<List<Integer>> combinationSum(int[] a, int t) {
            dfs(new ArrayList<>(), a, 0, t);
            return res;
        }
    }
}
