package a0001_0100;

public class A0053 {
    class Solution {

        private int solve1(int[] a) {
            int sum = 0, res = Integer.MIN_VALUE;
            for (int c : a) {
                sum += c;
                res = Math.max(res, sum);
                if (sum < 0) sum = 0;
            }
            return res;
        }

        private int solve2(int[] a) {
            int[] dp = new int[a.length];
            int res = a[0];
            dp[0] = a[0];
            for (int i = 1; i < a.length; i++) {
                dp[i] = dp[i - 1] > 0 ? dp[i - 1] + a[i] : a[i];
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        public int maxSubArray(int[] a) {
            if (a.length == 0) return 0;
            return solve1(a);
        }
    }
}
