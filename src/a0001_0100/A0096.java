package a0001_0100;

public class A0096 {
    class Solution {
        public int numTrees(int n) {
            if (n < 2) return 1;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                // 对于 i, 考虑
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - 1 - j];
                }
            }
            return dp[n];
        }
    }
}
