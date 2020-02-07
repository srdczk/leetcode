package a1301_1400;

import java.util.HashMap;

public class A1315 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    class Solution {
        private HashMap<TreeNode, TreeNode> map = new HashMap<>();
        private void dfs(TreeNode node, TreeNode father) {
            if (node == null) return;
            map.put(node, father);
            dfs(node.left, node);
            dfs(node.right, node);
        }
        private int res = 0;
        private void process(TreeNode node) {
            if (node == null) return;
            TreeNode father = map.get(node), grand;
            if (father != null && (grand = map.get(father)) != null && grand.val % 2 == 0) res += node.val;
            process(node.left);
            process(node.right);
        }
        public int sumEvenGrandparent(TreeNode root) {
            if (root == null) return res;
            dfs(root, null);
            process(root);
            return res;
        }
    }
}
