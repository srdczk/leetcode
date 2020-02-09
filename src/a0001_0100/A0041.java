package a0001_0100;

public class A0041 {
    class Solution {
        // 建立堆

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private void heapify(int[] a, int index, int size) {
            // 最小堆
            int left = 2 * index + 1;
            while (left < size) {
                int smallest = left + 1 < size && a[left + 1] < a[left] ? left + 1 : left;
                smallest = a[index] < a[smallest] ? index : smallest;
                if (smallest == index) break;
                swap(a, index, smallest);
                index = smallest;
                left = 2 * index + 1;
            }
        }

        public int firstMissingPositive(int[] nums) {
            if (nums.length == 0) return 1;
            int cnt = 1;
            for (int i = (nums.length - 1) / 2; i > -1; i--) {
                heapify(nums, i, nums.length);
            }
            // 已经是最小堆了
            int size = nums.length;
            if (nums[0] > 0) {
                if (nums[0] != cnt) return cnt;
                else cnt++;
            }
            swap(nums, 0, --size);
            while (size > 0) {
                heapify(nums, 0, size);
                if (nums[0] > 0) {
                    if (nums[0] == cnt) {
                        cnt++;
                    } else if (nums[0] != cnt - 1) return cnt;
                }
                swap(nums, 0, --size);
            }
            return cnt;
        }
    }
}
