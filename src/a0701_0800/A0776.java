package a0701_0800;
// Created by srdczk on 2020/1/16

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class A0776 {
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
        private List<Integer> pre = new ArrayList<>(), in = new ArrayList<>();
        private void preDfs(TreeNode node) {
            if (node == null) return;
            pre.add(node.val);
            preDfs(node.left);
            preDfs(node.right);
        }
        private void inDfs(TreeNode node) {
            if (node == null) return;
            inDfs(node.left);
            in.add(node.val);
            inDfs(node.right);
        }
        private TreeNode build(List<Integer> pre, int preStart, int preEnd, List<Integer> in, int inStart, int inEnd) {
            if (preStart > preEnd) return null;
            TreeNode node = new TreeNode(pre.get(preStart));
            for (int i = inStart; i < inEnd + 1; i++) {
                if (pre.get(preStart).equals(in.get(i))) {
                    node.left = build(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                    node.right = build(pre, i - inStart + preStart + 1, preEnd, in, i + 1, inEnd);
                    break;
                }
            }
            return node;
        }
        public TreeNode[] splitBST(TreeNode root, int v) {
            TreeNode[] res = new TreeNode[2];
            if (root == null) return res;
            if (root.val == v || root.val < v && (root.right == null || root.right.val > v)) {
                res[0] = root;
                res[1] = root.right;
                root.right = null;
                return res;
            }
            preDfs(root);
            inDfs(root);
            int left = 0, right = in.size() - 1, lastPos = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (in.get(mid) <= v) {
                    lastPos = mid;
                    left = mid + 1;
                } else right = mid - 1;
            }
            List<Integer> in0 = new ArrayList<>(), in1 = new ArrayList<>();
            List<Integer> pre0 = new ArrayList<>(), pre1 = new ArrayList<>();
            for (int i = 0; i < in.size(); i++) {
                if (i < lastPos + 1) in0.add(in.get(i));
                else in1.add(in.get(i));
            }
            for (int i = 0; i < pre.size(); i++) {
                if (in0.contains(pre.get(i))) pre0.add(pre.get(i));
                else pre1.add(pre.get(i));
            }
            res[0] = build(pre0, 0, pre0.size() - 1, in0, 0, in0.size() - 1);
            res[1] = build(pre1, 0, pre1.size() - 1, in1, 0, in1.size() - 1);
            return res;
        }
    }
}
