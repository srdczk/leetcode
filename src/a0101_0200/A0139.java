package a0101_0200;

import java.util.List;

public class A0139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (String word : wordDict) {
                    if (i >= word.length() && s.substring(i - word.length(), i).endsWith(word) && dp[i - word.length()]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
