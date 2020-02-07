package a0001_0100;

/**
 * created by srdczk 2019/11/6
 */
public class A0005 {
    class Solution {
        // manacher
        private char[] getProcessChar(String s) {
            char[] chs = new char[2 * s.length() + 1];
            for (int i = 0; i < chs.length; i++) {
                if (i % 2 == 0) chs[i] = '#';
                else chs[i] = s.charAt(i / 2);
            }
            return chs;
        }
        public String longestPalindrome(String s) {
            if (s.length() < 2) return s;
            char[] chs = getProcessChar(s);
            int R = -1, C = -1, pArray[] = new int[chs.length], max = 1, start = 0;
            for (int i = 0; i < pArray.length; i++) {
                // 如果边界 > i
                pArray[i] = R > i ? Math.min(R - i, pArray[2 * C - i]) : 1;
                while (i + pArray[i] < chs.length && i - pArray[i] > -1) {
                    if (chs[i + pArray[i]] == chs[i - pArray[i]]) pArray[i]++;
                    else break;
                }
                if (i + pArray[i] > R) {
                    R = i + pArray[i];
                    C = i;
                }
                if (pArray[i] > max) {
                    max = pArray[i];
                    start = (i - pArray[i] + 1) / 2;
                }
            }
            return s.substring(start, start + max - 1);
        }
    }
}
