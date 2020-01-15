package a1001_1100;
// Created by srdczk on 2020/1/15

import java.util.HashMap;

public class A1100 {
    class Solution {
        public int numKLenSubstrNoRepeats(String s, int k) {
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chs = s.toCharArray();
            for (int i = 0, j = 0; i < chs.length; i++) {
                if (map.getOrDefault(chs[i], -1) >= j) j = map.get(chs[i]) + 1;
                map.put(chs[i], i);
                res += i - j + 1 >= k ? 1 : 0;
            }
            return res;
        }
    }
}
