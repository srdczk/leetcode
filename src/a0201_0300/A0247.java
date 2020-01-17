package a0201_0300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A0247 {
    class Solution {
        private HashMap<Character, Character> map = new HashMap<>();
        {
            map.put('1', '1');
            map.put('0', '0');
            map.put('6', '9');
            map.put('8', '8');
            map.put('9', '6');
        }
        private char[] self = {'0', '1', '8'};
        private char[] other = {'6', '9'};
        private List<String> list = new ArrayList<>();
        private int len;
        private String process(char[] chs) {
            StringBuilder res = new StringBuilder(String.valueOf(chs));
            if (len % 2 == 1) {
                for (int i = chs.length - 2; i > -1; i--) {
                    res.append(map.get(chs[i]));
                }
            } else {
                for (int i = chs.length - 1; i > -1; i--) {
                    res.append(map.get(chs[i]));
                }
            }
            return res.toString();
        }
        private void dfs(StringBuilder sb, int level) {
            if (sb.length() == (len + 1) / 2) {
                if (sb.charAt(0) != '0' || len == 1) list.add(process(sb.toString().toCharArray()));
                return;
            }
            for (int i = 0; i < self.length; i++) {
                sb.append(self[i]);
                dfs(sb, level + 1);
                sb.setLength(level);
            }
            if (!(len % 2 == 1 && level == (len - 1) / 2)) {
                for (int i = 0; i < other.length; i++) {
                    sb.append(other[i]);
                    dfs(sb, level + 1);
                    sb.setLength(level);
                }
            }
        }
        public List<String> findStrobogrammatic(int n) {
            len = n;
            dfs(new StringBuilder(), 0);
            return list;
        }
    }
}
