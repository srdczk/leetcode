package a0801_0900;

public class A0889 {
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
        private TreeNode build(int[] pre, int preStart, int preEnd, int[] pos, int posStart, int posEnd) {
            if (preStart > preEnd) return null;
            if (preStart == preEnd) return new TreeNode(pre[preStart]);
            if (preStart + 1 == preEnd) {
                TreeNode node = new TreeNode(pre[preStart]);
                node.left = new TreeNode(pre[preEnd]);
                return node;
            }
            TreeNode node = new TreeNode(pre[preStart]);
            for (int i = posStart; i < posEnd; i++) {
                if (pos[i] == pre[preStart + 1]) {
                    node.left = build(pre, preStart + 1, i - posStart + preStart + 1, pos, posStart, i);
                    node.right = build(pre, i - posStart + preStart + 2, preEnd, pos, i + 1, posEnd - 1);
                    break;
                }
            }
            return node;
        }
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return build(pre, 0, pre.length - 1, post, 0, post.length - 1);
        }
    }
}
