package a0101_0200;

public class A0124 {
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
    }
    class Solution {
        private int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            process(root);
            return res;
        }
        private int process(TreeNode node) {
            if (node == null) return 0;
            int left = Math.max(0, process(node.left));
            int right = Math.max(0, process(node.right));
            res = Math.max(res, node.val + left + right);
            return node.val + Math.max(left, right);
        }
    }
}
