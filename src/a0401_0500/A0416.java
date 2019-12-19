package a0401_0500;

import java.util.Arrays;

public class A0416 {
    class Solution {
        // 递归方法
        private boolean res = false;
        private void dfs(int[] a, int level, int sum) {
            if (res) return;
            if (sum == 0) {
                res = true;
                return;
            }
            for (int i = level; i > -1; i--) {
                if (a[i] <= sum) {
                    dfs(a, i - 1, sum - a[i]);
                }
            }
        }
        public boolean recursionSolve(int[] a) {
            int sum = 0;
            for (int c : a) sum += c;
            if (sum % 2 == 1) return false;
            for (int c : a) {
                if (c > sum / 2) return false;
                else if (c == sum / 2) return true;
            }

            dfs(a, a.length - 1, sum / 2);
            Arrays.sort(a);
            return res;
        }
        // 动态规划方法 < -- > 零钱兑换
        private boolean dpSolve(int[] a) {
            int sum = 0;
            for (int c : a) sum += c;
            if (sum % 2 == 1) return false;
            boolean[] dp = new boolean[sum / 2 + 1];
            dp[0] = true;
            for (int c : a) {
                for (int i = sum / 2; i > c - 1; i--) {
                    dp[i] |= dp[i - c];
                    if (dp[sum / 2]) return true;
                }
            }
            return dp[sum / 2];
        }
        public boolean canPartition(int[] a) {
            return dpSolve(a);
        }
    }
}
