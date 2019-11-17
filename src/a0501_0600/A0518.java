package a0501_0600;

public class A0518 {
    class Solution {
        public int change(int a, int[] as) {
            // 多重背包问题
            int[] dp = new int[a + 1];
            dp[0] = 1;
            for (int c : as) {
                for (int i = c; i < a + 1; ++i) dp[i] += dp[i - c];
            }
            return dp[a];
        }
    }
}
