package a0401_0500;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class A0474 {
    class Solution {
        private int[][] dp;
        private int cnt(String s) {
            int res = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') res++;
            }
            return res;
        }
        public int findMaxForm(String[] ss, int m, int n) {
            int res = 0;
            dp = new int[m + 1][n + 1];
            for (String s : ss) {
                int cnt1 = cnt(s), cnt0 = s.length() - cnt1;
                for (int i = m; i > cnt0 - 1; i--) {
                    for (int j = n; j > cnt1 - 1; j--) {
                        int x = i - cnt0, y = j - cnt1;
                        if (x == 0 && y == 0) dp[i][j] = Math.max(1, dp[i][j]);
                        else if (dp[x][y] != 0) dp[i][j] = Math.max(dp[x][y] + 1, dp[i][j]);
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res;
        }
    }
}
