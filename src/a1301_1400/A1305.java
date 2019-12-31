package a1301_1400;

import java.util.ArrayList;
import java.util.List;

public class A1305 {
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    class Solution {
        private List<Integer> res = new ArrayList<>(), a = new ArrayList<>(), b = new ArrayList<>();
        private void dfs(TreeNode node, boolean pd) {
            if (node == null) return;
            dfs(node.left, pd);
            if (pd) a.add(node.val);
            else b.add(node.val);
            dfs(node.right, pd);
        }
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            dfs(root1, true);
            dfs(root2, false);
            int i = 0, j = 0;
            while (i < a.size() && j < b.size()) {
                res.add(a.get(i) < b.get(j) ? a.get(i++) : b.get(j++));
            }
            while (i < a.size()) res.add(a.get(i++));
            while (j < b.size()) res.add(b.get(j++));
            return res;
        }
    }
}
