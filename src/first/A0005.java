package first;

/**
 * created by srdczk 2019/11/6
 */
public class A0005 {
    class Solution {

        /**
         *
         * manacher 算法, 先将字符串儿处理成无视基数, 偶数回文的形式:
         * aaa -> #a#a#a#   baab -> #b#a#a#b#
         * 根据两个变量R, C的关系分析是否是回文字符串, 时间复杂度为 O(n)
         */
        private char[] getProcessArray(String s) {
            char[] chs = s.toCharArray(), res = new char[2 * s.length() + 1];
            for (int i = 0; i < res.length; i++) {
                if (i % 2 == 0) res[i] = '#';
                else res[i] = chs[i / 2];
            }
            return res;
        }

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) return s;
            int b = 0, len = 1;
            char[] chs = getProcessArray(s);
            int pArray[] = new int[chs.length], R = -1, C = -1;
            for (int i = 0; i < pArray.length; i++) {
                pArray[i] = R > i ? Math.min(pArray[2 * C - i], R - i) : 1;
                while (i + pArray[i] < chs.length && i - pArray[i] > -1) {
                    if (chs[i + pArray[i]] == chs[i - pArray[i]]) pArray[i]++;
                    else break;
                }
                if (i + pArray[i] > R) {
                    R = i + pArray[i];
                    C = i;
                }
                if (pArray[i] - 1 > len) {
                    len = pArray[i] - 1;
                    b = (i - pArray[i] + 1) / 2;
                }
            }
            return s.substring(b, b + len);
        }
    }
}
