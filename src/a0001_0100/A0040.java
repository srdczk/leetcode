package a0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0040 {
    // 深度优先搜索, 由于不能重复使用数字, 每次不加 1 , 而是加到不同数为止
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private void dfs(List<Integer> list, int[] a, int t, int level) {
            if (t == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (level == a.length) return;
            int i = level, x = a[level];
            while (i < a.length) {
                if (a[i] <= t) {
                    list.add(a[i]);
                    dfs(list, a, t - a[i], i + 1);
                    list.remove(list.size() - 1);
                }
                while (i < a.length && a[i] == x) i++;
                if (i < a.length) x = a[i];
            }
        }

        public List<List<Integer>> combinationSum2(int[] a, int t) {
            Arrays.sort(a);
            dfs(new ArrayList<>(), a, t, 0);
            return res;
        }
    }
}
