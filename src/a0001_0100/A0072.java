package a0001_0100;

public class A0072 {
    class Solution {
        public int minDistance(String x, String y) {
            char[] a = x.toCharArray(), b = y.toCharArray();
            int[][] dp = new int[a.length + 1][b.length + 1];
            // b de length = 0;
            for (int i = 0; i < Math.max(a.length, b.length) + 1; i++) {
                if (i < a.length + 1) dp[i][0] = i;
                if (i < b.length + 1) dp[0][i] = i;
            }
            for (int i = 1; i < a.length + 1; i++) {
                for (int j = 1; j < b.length + 1; j++) {
                    if (a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                    // i - 1  j 删去 i, i j - 1 删去 j, i - 1 j - 1 修改 i = j
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
            return dp[a.length][b.length];
        }
    }
}
