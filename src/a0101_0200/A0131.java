package a0101_0200;

import java.util.ArrayList;
import java.util.List;
public class A0131 {
    class Solution {
        private char[] process(String s) {
            char[] res = new char[2 * s.length() + 1];
            for (int i = 0; i < res.length; i++) {
                if (i % 2 == 0) res[i] = '#';
                else res[i] = s.charAt(i / 2);
            }
            return res;
        }
        private List<List<String>> res = new ArrayList<>();

        private String string;
        private int[] pArray;

        private void dfs(int level, List<String> list) {
            if (level == pArray.length - 1) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = level + 1; i < pArray.length; i++) {
                // (i - level) 是 回文的
                if (pArray[i] > i - level) {
                    // 开始的点
                    list.add(string.substring((level + 1) / 2, (level + 1) / 2 + i - level));
                    dfs(2 * i - level, list);
                    list.remove(list.size() - 1);
                }
            }
        }

        public List<List<String>> partition(String s) {
            string = s;
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
            dfs(0, new ArrayList<>());
            return res;
        }
    }
}
