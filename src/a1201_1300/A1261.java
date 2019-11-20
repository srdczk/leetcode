package a1201_1300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A1261 {
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    class FindElements {

        private int[] a;

        private void bfs(TreeNode node) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            node.val = 0;
            queue.offer(node);
            while (!queue.isEmpty()) {
                list.add((node = queue.poll()).val);
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    queue.offer(node.right);
                }
            }
            a = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                a[i] = list.get(i);
            }
        }
        public FindElements(TreeNode root) {
            bfs(root);
        }

        public boolean find(int t) {
            int left = 0, right = a.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (a[mid] == t) return true;
                else if (a[mid] > t) right = mid - 1;
                else left = mid + 1;
            }
            return false;
        }
    }

}
