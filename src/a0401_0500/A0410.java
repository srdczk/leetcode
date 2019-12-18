package a0401_0500;

public class A0410 {
    class Solution {
        private boolean can(int[] a, int m, long t) {
            int cnt = 1;
            long sum = 0;
            for (int c : a) {
                if (c > t) return false;
                if (sum + (long)c > t) {
                    cnt++;
                    sum = c;
                } else sum += c;
            }
            // 可能做到
            // 如果 <= m
            return cnt <= m;
        }
        public int splitArray(int[] a, int m) {
            // m 个子数组 <--> 子数组 最大和最小
            long sum = 0;
            for (int c : a) sum += c;
            long left = 0, right = sum, lastPos = -1;
            while (left <= right) {
                long mid = left + ((right - left) >> 1);
                if (can(a, m, mid)) {
                    lastPos = mid;
                    right = mid - 1;
                } else left = mid + 1;
            }
            return (int) lastPos;
        }
    }
}
