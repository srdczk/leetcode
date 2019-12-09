package a0001_0100;

public class A0098 {
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
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        private boolean process(TreeNode node, long max, long min) {
            if (node == null) return true;
            if (node.val >= max || node.val <= min) return false;
            return process(node.left, node.val, min) && process(node.right, max, node.val);
        }
        public boolean isValidBST(TreeNode node) {
            return process(node, Long.MAX_VALUE, Long.MIN_VALUE);
        }
    }
}
