package a0501_0600;

import java.util.HashMap;

public class A0543 {
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
        private class ReturnType {
            int height, path;
            public ReturnType(int h, int p) {
                height = h;
                path = p;
            }
        }

        private ReturnType process(TreeNode node) {
            if (node == null) return new ReturnType(0, 0);
            ReturnType left = process(node.left);
            ReturnType right = process(node.right);
            ReturnType res = new ReturnType(Math.max(left.height, right.height) + 1, Math.max(Math.max(left.path, right.path), left.height + right.height));
            return res;
        }

        public int diameterOfBinaryTree(TreeNode node) {
            ReturnType type = process(node);
            return type.path;
        }
    }
}
