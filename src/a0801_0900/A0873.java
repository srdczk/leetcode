package a0801_0900;

public class A0873 {
    class Solution {
        private int res = 0;
        private int[] a;
        private void dfs(int len, int x, int y, int level) {
            res = Math.max(len, res);
            // 找第一个 >= x + y 的
            if (level > a.length - 1) return;
            if (level == a.length - 1) {
                if (a[level] == x + y) res = Math.max(len + 1, res);
                return;
            }
            // 二分搜索
            int left = level, right = a.length - 1, lastPos = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (a[mid] == x + y) {
                    lastPos = mid;
                    break;
                } else if (a[mid] > x + y) right = mid - 1;
                else left = mid + 1;
            }
            if (lastPos != -1) dfs(len + 1, y, a[lastPos], lastPos + 1);
        }
        public int lenLongestFibSubseq(int[] A) {
            a = A;
            if (a.length < 3) return 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    dfs(2, a[i], a[j], j + 1);
                }
            }
            return res < 3 ? 0 : res;
        }
    }
}
