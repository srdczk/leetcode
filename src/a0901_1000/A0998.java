package a0901_1000;
// Created by srdczk on 2020/1/2

public class A0998 {
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
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (val > root.val) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            } else {
                root.right = insertIntoMaxTree(root.right, val);
                return root;
            }
        }
    }
}
