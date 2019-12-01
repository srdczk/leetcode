package a0101_0200;

import java.util.Arrays;

public class A0132 {
    class Solution {
        private int[] pArray;
        private char[] process(String s) {
            char[] res = new char[2 * s.length() + 1];
            for (int i = 0; i < res.length; i++) {
                if (i % 2 == 0) res[i] = '#';
                else res[i] = s.charAt(i / 2);
            }
            return res;
        }
        private boolean isPalindromic(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }
            return true;
        }
        public int minCut(String s) {
            char[] chs = process(s);
            pArray = new int[chs.length];
            int R = -1, C = -1;
            for (int i = 0; i < pArray.length; i++) {
                pArray[i] = R > i ? Math.min(R - i, pArray[2 * C - i]) : 1;
                while (i + pArray[i] < chs.length && i - pArray[i] > -1) {
                    if (chs[i + pArray[i]] == chs[i - pArray[i]]) pArray[i]++;
                    else break;
                }
                if (i + pArray[i] > R) {
                    R = i + pArray[i];
                    C = i;
                }
            }
            int[] dp = new int[pArray.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            // i -> pArray.length()
            dp[pArray.length - 1] = 0;
            for (int i = pArray.length - 1; i > -1; i--) {
                for (int j = pArray[i]; j > 0; j--) {
                    dp[i - j + 1] = Math.min(dp[i - j + 1], dp[i + j - 1] + 1);
                }
            }
            return dp[0] - 1;
        }
    }
}
