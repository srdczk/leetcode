package a0001_0100;

public class A0010 {
    class Solution {
        public boolean isMatch(String s, String p) {
            char[] a = s.toCharArray(), b = p.toCharArray();
            boolean[][] dp = new boolean[a.length + 1][b.length + 1];
            for (int i = 0; i < a.length + 1; i++) {
                // i 表示
                dp[i][0] = i == 0 ? true : false;
            }
            for (int i = 1; i < b.length + 1; i++) {
                if (b[i - 1] == '*') {
                    if (i == 1) dp[0][i] = false;
                    else dp[0][i] = dp[0][i - 2];
                } else dp[0][i] = false;
            }
            for (int i = 1; i < a.length + 1; i++) {
                for (int j = 1; j < b.length + 1; j++) {
                    if (b[j - 1] >= 'a' && b[j - 1] <= 'z') {
                        if (a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                        else dp[i][j] = false;
                    } else {
                        if (b[j - 1] == '.') dp[i][j] = dp[i - 1][j - 1];
                        else {
                            // 若果等于 *
                            if (j > 1) {
                                if (b[j - 2] == '.') {
                                    for (int k = 0; k < i + 1; k++) {
                                        if (dp[k][j - 2]) {
                                            dp[i][j] = true;
                                            break;
                                        }
                                    }
                                } else {
                                    char c = b[j - 2];
                                    int q = i - 1;
                                    while (q > -1 && a[q] == c) {
                                        if (dp[q + 1][j - 2]) {
                                            dp[i][j] = true;
                                            break;
                                        }
                                        q--;
                                    }
                                    if (dp[q + 1][j - 2]) dp[i][j] = true;
                                }
                            }
                        }
                    }
                }
            }
            return dp[a.length][b.length];
        }
    }
}
