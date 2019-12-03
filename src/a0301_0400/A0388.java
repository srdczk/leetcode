package a0301_0400;

import java.util.HashMap;

public class A0388 {
    class Solution {
        private int cnt(String s) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == '\t') i++;
            return i;
        }
        public int lengthLongestPath(String input) {
            String[] ss = input.split("\n");
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(-1, -1);
            int res = 0;
            for (String s : ss) {
                int cnt = cnt(s);
                s = s.substring(cnt);
                if (s.indexOf('.') == -1) {
                    map.put(cnt, map.get(cnt - 1) + 1 + s.length());
                } else {
                    res = Math.max(res, map.get(cnt - 1) + s.length() + 1);
                }
            }
            return res;
        }
    }
}
