package a0401_0500;

public class A0424 {
    class Solution {

        public int characterReplacement(String s, int k) {
            int[] cnt = new int[26];
            char[] chs = s.toCharArray();
            int res = 0;
            for (int i = 0, j = 0; i < chs.length; i++) {
                cnt[chs[i] - 'A']++;
                while (i - j + 1 - count(cnt) > k) {
                    cnt[chs[j++] - 'A']--;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
        private int count(int[] cnt) {
            int res = 0;
            for (int c : cnt) {
                res = Math.max(res, c);
            }
            return res;
        }
    }
}
