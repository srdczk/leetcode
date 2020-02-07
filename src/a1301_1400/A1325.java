package a1301_1400;

import java.util.*;

public class A1325 {
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
        private HashSet<TreeNode> set = new HashSet<>();

        private HashMap<TreeNode, TreeNode> map = new HashMap<>();

        private TreeNode process(TreeNode node, int t) {
            if (node == null) return node;
            Iterator<TreeNode> iterator = set.iterator();
            boolean x = true;
            while (iterator.hasNext()) {
                TreeNode p = iterator.next();
                if (p.left == null && p.right == null) {
                    x = false;
                    if (map.get(p) == null) return null;
                    else if (map.get(p).left == p) map.get(p).left = null;
                    else map.get(p).right = null;
                    iterator.remove();
                }
            }
            if (x) return node;
            else return process(node, t);
        }

        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) return null;
            map.put(root, null);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                if (p.val == target) set.add(p);
                if (p.left != null) {
                    queue.offer(p.left);
                    map.put(p.left, p);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    map.put(p.right, p);
                }
            }
            return process(root, target);
        }
    }
}
