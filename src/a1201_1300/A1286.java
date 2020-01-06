package a1201_1300;
// Created by srdczk on 2020/1/6

import java.util.ArrayList;
import java.util.List;

public class A1286 {
    class CombinationIterator {
        private int cnt = 0;

        private List<String> list = new ArrayList<>();

        private void dfs(StringBuilder sb, char[] chs, int level, int len) {
            if (sb.length() == len) {
                list.add(sb.toString());
                return;
            }
            for (int i = level; i < chs.length; i++) {
                int p = sb.length();
                sb.append(chs[i]);
                dfs(sb, chs, i + 1, len);
                sb.setLength(p);
            }
        }

        public CombinationIterator(String characters, int combinationLength) {
            dfs(new StringBuilder(), characters.toCharArray(), 0, combinationLength);
        }

        public String next() {
            return list.get(cnt++);
        }

        public boolean hasNext() {
            return cnt != list.size();
        }
    }
}
