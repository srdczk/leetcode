package a0301_0400;

public class A0312 {
    class Solution {

        private int[] a;

        private int[][] dp;

        private int dfs(int i, int j) {
            if (dp[i][j] > 0) return dp[i][j];
            int res = 0;
            for (int k = i; k < j + 1; k++) {
                res = Math.max(res, a[k] * a[i - 1] * a[j + 1] + dfs(i, k - 1) + dfs(k + 1, j));
            }
            dp[i][j] = res;
            return res;
        }

        public int maxCoins(int[] nums) {
            a = new int[nums.length + 2];
            System.arraycopy(nums, 0, a, 1, nums.length);
            a[0] = 1;
            a[a.length - 1] = 1;
            dp = new int[a.length][a.length];
            return dfs(1, a.length - 2);
        }
    }
}
