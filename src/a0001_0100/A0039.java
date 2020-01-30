package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0039 {
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] a;
        private void dfs(List<Integer> list, int level, int sum) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = level; i < a.length; i++) {
                if (sum >= a[i]) {
                    list.add(a[i]);
                    dfs(list, i, sum - a[i]);
                    list.remove(list.size() - 1);
                }
            }
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            a = candidates;
            dfs(new ArrayList<>(), 0, target);
            return res;
        }
    }
}
