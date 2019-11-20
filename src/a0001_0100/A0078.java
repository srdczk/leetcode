package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0078 {
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private void dfs(List<Integer> list, int[] a, int level) {
            res.add(new ArrayList<>(list));
            for (int i = level; i < a.length; i++) {
                list.add(a[i]);
                dfs(list, a, i + 1);
                list.remove(list.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] a) {
            dfs(new ArrayList<>(), a, 0);
            return res;
        }
    }
}
