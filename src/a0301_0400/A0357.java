package a0301_0400;

public class A0357 {
    class Solution {
//        (A (10)(n)) - (A (9)(n - 1))
        private int[] k;
        void init() {
            k = new int[11];
            k[0] = 1;
            for (int i = 1; i < k.length; i++) {
                k[i] = i * k[i - 1];
            }
        }
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            if (n == 1) return 10;
            if (n > 10) return countNumbersWithUniqueDigits(10);
            init();
            int[] dp = new int[n + 1];
            dp[1] = 10;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + k[10] / k[10 - i] - k[9] / k[10 - i];
            }
            return dp[n];
        }
    }
}
