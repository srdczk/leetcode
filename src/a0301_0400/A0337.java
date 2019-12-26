package a0301_0400;

import java.util.HashMap;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/26
 * @Description: a0301_0400
 * @version: 1.0
 */
public class A0337 {
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    class Solution {
        private HashMap<TreeNode, Integer> map = new HashMap<>();
        {
            map.put(null, 0);
        }
        public int rob(TreeNode node) {
            if (map.containsKey(node)) return map.get(node);
            if (node == null) return 0;
            int left = rob(node.left), right = rob(node.right);
            int res = left + right;
            int p = node.left == null ? 0 : rob(node.left.left) + rob(node.left.right);
            int q = node.right == null ? 0 : rob(node.right.left) + rob(node.right.right);
            res = Math.max(res, p + q + node.val);
            map.put(node, res);
            return res;
        }
    }
}
