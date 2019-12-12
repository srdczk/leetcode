package a1101_1200;

public class A1186 {
    class Solution {
        public int maximumSum(int[] a) {
            if (a.length < 2) return a.length == 0 ? 0 : a[0];
            int res = a[0];
            int[] dpA = new int[a.length], dpB = new int[a.length];
            dpA[0] = a[0];
            for (int i = 1; i < a.length; i++) {
                dpA[i] = dpA[i - 1] > 0 ? dpA[i - 1] + a[i] : a[i];
                // dp[B] 删除 了一次的
                dpB[i] = Math.max(dpB[i - 1] + a[i], dpA[i - 1]);
                res = Math.max(res, Math.max(dpB[i], dpA[i]));
            }
            return res;
        }
    }
}
