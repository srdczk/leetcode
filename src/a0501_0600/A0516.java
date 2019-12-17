package a0501_0600;

import java.util.Arrays;

public class A0516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            // 最长回文子序列
            // i - j 最长序列
            char[] chs = s.toCharArray();
            int[][] dp = new int[chs.length + 1][chs.length + 1];
            for (int i = 0; i < chs.length; i++) {
                for (int j = i; j > -1; j--) {
                    if (i == j) dp[i][j] = 1;
                    else {
                        if (chs[i] == chs[j]) dp[i][j] = dp[i - 1][j + 1] + 2;
                        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                    }
                }
            }
            return dp[chs.length - 1][0];
        }
    }
}
