package a0601_0700;
// Created by srdczk on 2020/1/2

public class A0654 {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    class Solution {
        private int maxIndex(int[] a, int i, int j) {
            if (i == j) return i;
            int res = i, pRes = a[i];
            for (int k = i + 1; k < j + 1; k++) {
                if (a[k] > pRes) {
                    res = k;
                    pRes = a[k];
                }
            }
            return res;
        }
        private TreeNode build(int[] a, int i, int j) {
            if (i > j) return null;
            int maxIndex = maxIndex(a, i, j);
            TreeNode node = new TreeNode(a[maxIndex]);
            node.left = build(a, i, maxIndex - 1);
            node.right = build(a, maxIndex + 1, j);
            return node;
        }
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }
    }
}
