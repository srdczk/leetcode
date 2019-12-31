package a1301_1400;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class A1302 {
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
        private int max = 0, cnt = 0;
        private HashMap<TreeNode, Integer> map = new HashMap<>();
        private void bfs(TreeNode node) {
            map.put(node, 0);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                int height = map.get(node);
                if (height > max) {
                    max = height;
                    cnt = node.val;
                } else if (height == max) cnt += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    map.put(node.left, height + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.put(node.right, height + 1);
                }
            }
        }
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) return 0;
            bfs(root);
            return cnt;
        }
    }
}
