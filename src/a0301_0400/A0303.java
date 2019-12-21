package a0301_0400;

public class A0303 {
    class NumArray {

        // 构建 线段树

        private int[] tree, data;

        private void build(int treeIndex, int i, int j) {
            if (i > j) return;
            if (i == j) {
                tree[treeIndex] = data[i];
                return;
            }
            int left = treeIndex * 2 + 1, right = treeIndex * 2 + 2, mid = i + ((j - i) >> 1);
            build(left, i, mid);
            build(right, mid + 1, j);
            tree[treeIndex] = tree[left] + tree[right];
        }

        public NumArray(int[] nums) {
            data = nums;
            tree = new int[data.length * 4];
            build(0, 0, data.length - 1);
        }
        // treeIndex x, y 表示 此树
        private int sum(int treeIndex, int x, int y, int i, int j) {
            if (i == j) return data[i];
            if (x == i && y == j) return tree[treeIndex];
            int mid = x + ((y - x) >> 1);
            if (i > mid) return sum(treeIndex * 2 + 2, mid + 1, y, i, j);
            else if (j < mid + 1) return sum(treeIndex * 2 + 1, x, mid, i, j);
            return sum(treeIndex * 2 + 1, x, mid, i, mid) + sum(treeIndex * 2 + 2, mid + 1, y, mid + 1, j);
        }

        public int sumRange(int i, int j) {
            return sum(0, 0, data.length - 1, i, j);
        }
    }

}
