package a0201_0300;

public class A0300 {
    class Solution {
        public int lengthOfLIS(int[] a) {
            int[] dp = new int[a.length];
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[i] > a[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res, dp[i]);
            }
            return Math.min(a.length, res + 1);
        }
    }
}
