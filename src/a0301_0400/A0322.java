package a0301_0400;

import java.util.Arrays;

public class A0322 {
    class Solution {
        // 多重背包问题
        public int coinChange(int[] as, int a) {
            int[] dp = new int[a + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int c : as) {
                for (int i = c; i < a + 1; i++) {
                    if (dp[i - c] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
            return dp[a] == Integer.MAX_VALUE ? -1 : dp[a];
        }
    }
}
