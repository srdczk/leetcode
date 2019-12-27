package a0101_0200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A0140 {
    class Solution {
        private List<String> res = new ArrayList<>();
        private HashSet<String> set;
        public boolean process(String s, List<String> wordDict) {
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
        private void dfs(String remain, StringBuilder sb) {
            if (remain.length() == 0) {
                res.add(sb.toString());
                return;
            }
            for (int i = 1; i < remain.length() + 1; i++) {
                if (set.contains(remain.substring(0, i))) {
                    int len = sb.length();
                    if (len > 0) sb.append(' ');
                    sb.append(remain.substring(0, i));
                    dfs(remain.substring(i), sb);
                    sb.setLength(len);
                }
            }
        }
        public List<String> wordBreak(String s, List<String> wordDict) {
            set = new HashSet<>(wordDict);
            if (!process(s, wordDict)) return res;
            dfs(s, new StringBuilder());
            return res;
        }
    }
}
