package a0201_0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A0297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode node) {
            if (node == null) return "#_";
            StringBuilder sb = new StringBuilder();
            sb.append(node.val).append("_");
            sb.append(serialize(node.left));
            sb.append(serialize(node.right));
            return sb.toString();
        }



        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] ss = data.split("_");
            Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
            return process(queue);
        }
        private TreeNode process(Queue<String> queue) {
            String s = queue.poll();
            if (s.equals("#")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = process(queue);
            node.right = process(queue);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
