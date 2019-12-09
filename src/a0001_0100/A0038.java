package a0001_0100;

public class A0038 {
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";
            String[] dp = new String[n + 1];
            dp[1] = "1";
            for (int i = 2; i < n + 1; i++) {
                int cnt = 0, x = dp[i - 1].charAt(0);
                StringBuilder sb = new StringBuilder();
                for (char c : dp[i - 1].toCharArray()) {
                    if (c == x) cnt++;
                    else {
                        sb.append(cnt).append((char)x);
                        x = c;
                        cnt = 1;
                    }
                }
                sb.append(cnt).append((char)x);
                dp[i] = sb.toString();
            }
            return dp[n];
        }
    }
}
