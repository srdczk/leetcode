package a0401_0500;

public class A0450 {
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
        // 删除根节点 <-->左子树的最右节点
        private TreeNode del(TreeNode node) {
            if (node.left == null) {
                TreeNode res = node.right;
                node.right = null;
                return res;
            }
            if (node.left.right == null) {
                TreeNode res = node.left;
                res.right = node.right;
                node.left = null;
                node.right = null;
                return res;
            }
            TreeNode pre = node.left;
            TreeNode right = node.left.right;
            while (right.right != null) {
                pre = right;
                right = right.right;
            }
            pre.right = right.left;
            right.left = node.left;
            right.right = node.right;
            node.left = null;
            node.right = null;
            return right;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return root;
            // 在二叉搜索树中
            if (root.val == key) return del(root);
            else {
                TreeNode pre = root;
                TreeNode node;
                if (root.val > key) node = root.left;
                else node = root.right;
                while (node != null && node.val != key) {
                    pre = node;
                    if (node.val > key) node = node.left;
                    else node = node.right;
                }
                if (node == null) return root;
                if (node == pre.left) pre.left = del(node);
                else pre.right = del(node);
                return root;
            }
        }
    }

}
