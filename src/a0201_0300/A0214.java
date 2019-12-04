package a0201_0300;

public class A0214 {
    class Solution {
        private char[] process(String s) {
            char[] res = new char[2 * s.length() + 1];
            for (int i = 0; i < res.length; i++) {
                if (i % 2 == 0) res[i] = '#';
                else res[i] = s.charAt(i / 2);
            }
            return res;
        }
        public String shortestPalindrome(String s) {
            int res = 1;
            char[] chs = process(s);
            int pArray[] = new int[chs.length], R = -1, C = -1;
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
                if (pArray[i] - 1 == i) res = i;
            }
            return new StringBuilder(s.substring(res)).reverse().append(s).toString();
        }
    }
}
