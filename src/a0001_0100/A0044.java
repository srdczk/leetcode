package a0001_0100;

public class A0044 {
    class Solution {
        public boolean isMatch(String s, String p) {
            // b 模式串
            // 一个jl j - 1的
            char[] a = s.toCharArray(), b = p.toCharArray();
            boolean[][] dp = new boolean[a.length + 1][b.length + 1];
            boolean[] jl = new boolean[b.length + 1];
            jl[0] = true;
            dp[0][0] = true;
            for (int i = 1; i < b.length + 1; i++) {
                dp[0][i] = b[i - 1] == '*' ? dp[0][i - 1] : false;
                if (dp[0][i]) jl[i] = true;
            }
            for (int i = 1; i < a.length + 1; i++) {
                dp[i][0] = false;
            }
            for (int i = 1; i < a.length + 1; i++) {
                for (int j = 1; j < b.length + 1; j++) {
                    if (b[j - 1] == '?') {
                        dp[i][j] |= dp[i - 1][j - 1];
                    } else if (b[j - 1] == '*') {

                        if (jl[j - 1]) dp[i][j] = true;

                    } else {
                        if (a[i - 1] == b[j - 1]) dp[i][j] |= dp[i - 1][j - 1];
                    }
                    if (dp[i][j]) jl[j] = true;
                }
            }
            return dp[a.length][b.length];
        }
    }
}
