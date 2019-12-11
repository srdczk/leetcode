package a0701_0800;

public class A0726 {
    class Solution {
        private char[] chs;
        private int[] process(int i, int j) {
            int[] res = new int[27 * 26];
            while (i < j + 1) {
                if (chs[i] >= 'A' && chs[i] <= 'Z') {
                    if (i == j || !(chs[i + 1] >= 'a' && chs[i + 1] <= 'z')) {
                        int x = (chs[i++] - 'A') * 27, cnt = 0;
                        while (i < j + 1 && Character.isDigit(chs[i])) {
                            cnt = cnt * 10 + chs[i++] - '0';
                        }
                        if (cnt == 0) res[x]++;
                        else res[x] += cnt;
                    } else {
                        int x = (chs[i++] - 'A') * 27, cnt = 0;
                        x += chs[i++] - 'a' + 1;
                        while (i < j + 1 && Character.isDigit(chs[i])) {
                            cnt = cnt * 10 + chs[i++] - '0';
                        }
                        if (cnt == 0) res[x]++;
                        else res[x] += cnt;
                    }
                } else {
                    // ()
                    int cnt = 1, begin = ++i;
                    while (i < j + 1 && cnt != 0) {
                        if (chs[i] == '(') cnt++;
                        else if (chs[i] == ')') cnt--;
                        i++;
                    }
                    int[] p = process(begin, i - 2);
                    cnt = 0;
                    while (i < j + 1 && Character.isDigit(chs[i])) {
                        cnt = cnt * 10 + chs[i++] - '0';
                    }
                    cnt = cnt == 0 ? 1 : cnt;
                    for (int k = 0; k < p.length; k++) {
                        res[k] += cnt * p[k];
                    }
                }
            }
            return res;
        }
        private String toString(int i) {
            if (i % 27 == 0) return String.valueOf((char)('A' + i / 27));
            StringBuilder res = new StringBuilder();
            res.append((char)('A' + i / 27)).append((char)('a' + i % 27 - 1));
            return res.toString();
        }
        public String countOfAtoms(String formula) {
            chs = formula.toCharArray();
            int[] res = process(0, chs.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (res[i] > 0) {
                    if (res[i] == 1) sb.append(toString(i));
                    else sb.append(toString(i)).append(res[i]);
                }
            }
            return sb.toString();
        }
    }
}
