package a1201_1300;

import java.util.HashMap;
import java.util.HashSet;

public class A1297 {
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            char[] chs = s.toCharArray();
            int res = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = minSize - 1; i < chs.length; i++) {
                int cnt = 1;
                HashSet<Character> set = new HashSet<>();
                set.add(chs[i]);
                while (cnt < maxSize + 1) {
                    if (set.size() > maxLetters) break;
                    if (cnt > minSize - 1) {
                        String tmp = s.substring(i + 1 - cnt, i + 1);
                        int k = map.getOrDefault(tmp, 0) + 1;
                        res = Math.max(res, k);
                        map.put(tmp, k);
                    }
                    if (cnt == i + 1 || cnt == maxSize) break;
                    // 否则 继续加入
                    set.add(chs[i + 1 - ++cnt]);
                }
            }
            return res;
        }
    }
}
