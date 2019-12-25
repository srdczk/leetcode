package a0701_0800;

public class A0799 {
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            int q = Math.max(query_glass, query_row);
            double[][] dp = new double[q + 1][q + 1];
            dp[0][0] = poured;
            for (int i = 0; i < q + 1; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (dp[i][j] > 1.0) {
                        if (i + 1 < q + 1 && j < q + 1) dp[i + 1][j] += (dp[i][j] - 1.0) / 2.0;
                        if (i + 1 < q + 1 && j + 1 < q + 1) dp[i + 1][j + 1] += (dp[i][j] - 1.0) / 2.0;
                    }
                }
            }
            return dp[query_row][query_glass] > 1.0 ? 1.0 : dp[query_row][query_glass];
        }
    }
}
