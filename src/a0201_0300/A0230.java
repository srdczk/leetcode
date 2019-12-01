package a0201_0300;

public class A0230 {
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    class Solution {
        private int k;
        private int cnt = 0;
        private Integer res = null;
        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            if (++cnt > k) return;
            res = node.val;
            dfs(node.right);
        }
        public int kthSmallest(TreeNode node, int k) {
            this.k = k;
            dfs(node);
            return res;
        }
    }
}
