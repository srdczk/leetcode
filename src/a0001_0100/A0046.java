package a0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0046 {
    // 不同整数的全排列, 直接回溯
    class Solution {
        private void swap(Integer[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        private List<List<Integer>> res = new ArrayList<>();
        private void dfs(int level, Integer[] a) {
            if (level == a.length) {
                res.add(new ArrayList<>(Arrays.asList(a)));
                return;
            }
            for (int i = level; i < a.length; i++) {
                swap(a, level, i);
                dfs(level + 1, a);
                swap(a, level, i);
            }
        }
        public List<List<Integer>> permute(int[] a) {
            Integer[] p = new Integer[a.length];
            for (int i = 0; i < a.length; i++) {
                p[i] = a[i];
            }
            dfs(0, p);
            return res;
        }
    }

}
