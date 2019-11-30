package a0001_0100;

public class A0091 {
    class Solution {
        public int numDecodings(String s) {
            char[] chs = s.toCharArray();
            int[] dp = new int[chs.length + 1];
            // 从后往前 dp dp[i] i - chs.length 由几个
            for (int i = dp.length - 1; i > -1; i--) {
                if (i == dp.length - 1) dp[i] = 1;
                else if (chs[i] == '0') dp[i] = 0;
                else {
                    if ((chs[i] == '1' && i < chs.length - 1)
                            || (chs[i] == '2' && i < chs.length - 1 && chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                        dp[i] = dp[i + 1] + dp[i + 2];
                    } else dp[i] = dp[i + 1];
                }
            }
            return dp[0];
        }
    }
}
