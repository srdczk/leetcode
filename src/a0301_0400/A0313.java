package a0301_0400;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A0313 {
    // 和丑数的做法一样
    class Solution {
        public int nthSuperUglyNumber(int n, int[] ps) {
            int dp[] = new int[n], x[] = new int[ps.length], i = 1;
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 1;
            while (i < n) {
                for (int j = 0; j < ps.length; j++) {
                    dp[i] = Math.min(ps[j] * dp[x[j]], dp[i]);
                }
                for (int j = 0; j < ps.length; j++) {
                    if (dp[i] == ps[j] * dp[x[j]]) x[j]++;
                }
                i++;
            }
            return dp[n - 1];
        }
    }
}
