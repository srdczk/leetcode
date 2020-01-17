package a0201_0300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0267 {
    class Solution {
        private List<String> list = new ArrayList<>();
        private void swap(char[] chs, int i, int j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
        }
        private Character x = null;
        private int len;
        private String process(char[] chs) {
            StringBuilder sb = new StringBuilder(String.valueOf(chs));
            if (len % 2 == 1) {
                sb.append(x);
            }
            for (int i = chs.length - 1; i > -1; i--) sb.append(chs[i]);
            return sb.toString();
        }
        private void dfs(char[] chs, int level) {
            if (level == chs.length) {
                list.add(process(chs));
                return;
            }
            for (int i = level; i < chs.length; i++) {
                if (can(chs, level, i)) {
                    swap(chs, i, level);
                    dfs(chs, level + 1);
                    swap(chs, i, level);
                }
            }
        }
        private boolean can(char[] chs, int i, int j) {
            if (i == j) return true;
            for (int k = i; k < j; k++) {
                if (chs[k] == chs[j]) return false;
            }
            return true;
        }
        public List<String> generatePalindromes(String s) {
            int[] cnt = new int[128];
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) cnt[c]++;
            len = s.length();
            for (char c : s.toCharArray()) {
                if (cnt[c] > 0) {
                    if (cnt[c] % 2 == 1) {
                        if (len % 2 == 0) return list;
                        else if (x == null) {
                            x = c;
                            cnt[c]--;
                        } else return list;
                    } else {
                        sb.append(c);
                        cnt[c] -= 2;
                    }
                }
            }
            char[] chs = sb.toString().toCharArray();
            Arrays.sort(chs);
            dfs(chs, 0);
            return list;
        }
    }
}
