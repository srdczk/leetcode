package a0601_0700;

public class A0647 {
    class Solution {
        // manacher 算法求解
        private char[] process(String s) {
            char[] res = new char[2 * s.length() + 1];
            for (int i = 0; i < res.length; i++) {
                if (i % 2 == 0) res[i] = '#';
                else res[i] = s.charAt(i / 2);
            }
            return res;
        }
        public int countSubstrings(String s) {
            char[] chs = process(s);
            int res = 0, R = -1, C = -1, pArray[] = new int[chs.length];
            for (int i = 0; i < pArray.length; i++) {
                pArray[i] = R > i ? Math.min(R - i, pArray[2 * C - i]) : 1;
                while (i + pArray[i] < chs.length && i - pArray[i] > -1) {
                    if (chs[i + pArray[i]] == chs[i - pArray[i]]) pArray[i]++;
                    else break;
                }
                if (i + pArray[i] > R) {
                    R = pArray[i] + i;
                    C = i;
                }
                res += pArray[i] / 2;
            }
            return res;
        }
    }
}
