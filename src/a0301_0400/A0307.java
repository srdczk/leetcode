package a0301_0400;

public class A0307 {
    class NumArray {
        // 线段树 递归
        private int[] tree;
        private int[] data;
        // 建立 线段树的操作
        private void build(int treeIndex, int i, int j) {
            if (i > j) return;
            if (i == j) {
                tree[treeIndex] = data[i];
                return;
            }
            int left = 2 * treeIndex + 1, right = 2 * treeIndex + 2, mid = i + ((j - i) >> 1);
            build(left, i, mid);
            build(right, mid + 1, j);
            tree[treeIndex] = tree[left] + tree[right];
        }

        public NumArray(int[] nums) {
            data = nums;
            tree = new int[data.length * 4];
            build(0, 0, data.length - 1);
        }

        private int sum(int treeIndex, int x, int y, int i, int j) {
            if (i > j) return 0;
            if (i == j) return data[i];
            int left = 2 * treeIndex + 1, right = 2 * treeIndex + 2, mid = x + ((y - x) >> 1);
            if (i > mid) return sum(right, mid + 1, y, i, j);
            else if (j < mid + 1) return sum(left, x, mid, i, j);
            return sum(left, x, mid, i, mid) + sum(right, mid + 1, y, mid + 1, j);
        }

        public int sumRange(int i, int j) {
            return sum(0, 0, data.length - 1, i, j);
        }

        private void set(int treeIndex, int x, int y, int i) {
            if (x > y) return;
            if (x == y) {
                tree[treeIndex] = data[i];
                return;
            }
            int mid = x + ((y - x) >> 1), left = 2 * treeIndex + 1, right = 2 * treeIndex + 2;
            if (i < mid + 1) set(left, x, mid, i);
            else set(right, mid + 1, y, i);
            tree[treeIndex] = tree[left] + tree[right];
        }

        public void update(int i, int val) {
            data[i] = val;
            set(0, 0, data.length - 1, i);
        }
    }
}
