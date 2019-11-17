package a0201_0300;

public class A0215 {
    class Solution {
        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        // 求数组的第 k 大元素
        // 方法 1 用 堆时间复杂度 n * log(k)
        // 最大堆的向下调整
        private void heapify(int[] a, int index, int size) {
            int left = 2 * index + 1;
            while (left < size) {
                int largest = left + 1 < size && a[left + 1] > a[left] ? left + 1 : left;
                largest = a[largest] > a[index] ? largest : index;
                if (largest == index) break;
                swap(a, index, largest);
                index = largest;
                left = 2 * index + 1;
            }
        }

        private int heapSolve(int[] a, int k) {

            for (int i = (a.length - 1) / 2; i > -1; i--) heapify(a, i, a.length);
            int cnt = 1, size = a.length;
            if (cnt++ == k) return a[0];
            swap(a, 0, --size);
            while (size > 0) {
                heapify(a, 0, size);
                if (cnt++ == k) return a[0];
                swap(a, 0, --size);
            }
            return -1;
        }
        // 方法 2 使用快速排序中 parititon 的思想
        // 把前 k 个最大的值 都放在 后面, 再遍历一次, 事件复杂度为 O(n)
        private int partition(int[] a, int l, int r) {
            int val = a[l];
            while (l < r) {
                while (l < r && a[r] > val) r--;
                swap(a, l, r);
                while (l < r && a[l] <= val) l++;
                swap(a, l, r);
            }
            return l;
        }

        private int res(int[] a, int l, int r, int k) {
            int p = partition(a, l, r);
            if (p == k) return a[p];
            else if (p > k) return res(a, l, p - 1, k);
            else return res(a, p + 1, r, k);
        }

        private int partitionSolve(int[] a, int k) {

            return res(a, 0, a.length - 1, a.length - k);

        }
        public int findKthLargest(int[] nums, int k) {
//            return heapSolve(nums, k);
            return partitionSolve(nums, k);
        }
    }
}
