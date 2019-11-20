package a0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0090 {
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private void dfs(List<Integer> list, int[] a, int level) {
            res.add(new ArrayList<>(list));
            if (level == a.length) return;
            int i = level, x = a[level];
            while (i < a.length) {
                list.add(a[i]);
                dfs(list, a, i + 1);
                list.remove(list.size() - 1);
                while (i < a.length && a[i] == x) i++;
                if (i < a.length) x = a[i];
            }
        }
        public List<List<Integer>> subsetsWithDup(int[] a) {
            Arrays.sort(a);
            dfs(new ArrayList<>(), a, 0);
            return res;
        }
    }
}
