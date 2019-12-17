package a1101_1200;

public class A1143 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] a = text1.toCharArray(), b = text2.toCharArray();
            int[][] dp = new int[a.length + 1][b.length + 1];
            for (int i = 1; i < a.length + 1; i++) {
                for (int j = 1; j < b.length + 1; j++) {
                    if (a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
                }
            }
            return dp[a.length][b.length];
        }
    }
}
