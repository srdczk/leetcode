package a0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0047 {
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private void swap(Integer[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private void dfs(int level, Integer[] a) {
            if (level == a.length) {
                res.add(new ArrayList<>(Arrays.asList(a)));
                return;
            }
            for (int i = level; i < a.length; i++) {
                if (pd(a, level, i)) {
                    swap(a, level, i);
                    dfs(level + 1, a);
                    swap(a, level, i);
                }
            }
        }

        private boolean pd(Integer[] a, int i, int j) {
            if (i == j) return true;
            // 已经出现过的直接跳过了, 避免重复
            for (int k = i; k < j; k++) {
                if (a[k].equals(a[j])) return false;
            }
            return true;
        }

        public List<List<Integer>> permuteUnique(int[] a) {
            Integer[] p = new Integer[a.length];
            for (int i = 0; i < a.length; i++) p[i] = a[i];
            dfs(0, p);
            return res;
        }
    }
}
