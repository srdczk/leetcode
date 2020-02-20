package a0301_0400;

public class A0312 {
    class Solution {
        private int[][] dp;

        private int process(int[] nums, int i, int j) {
            if (i > j) return 0;
            if (dp[i][j] > 0) return dp[i][j];
            int res = 0;
            for (int k = i; k < j + 1; k++) {
                int p = process(nums, i, k - 1) + process(nums, k + 1, j) + nums[k] * nums[i - 1] * nums[j + 1];
                res = Math.max(res, p);
            }
            dp[i][j] = res;
            return res;
        }

        public int maxCoins(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length < 3) return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]) + nums[0] * nums[1];
            int[] a = new int[nums.length + 2];
            System.arraycopy(nums, 0, a, 1, nums.length);
            a[0] = 1;
            a[a.length - 1] = 1;
            dp = new int[a.length][a.length];
            return process(a, 1, a.length - 2);
        }
    }
}
