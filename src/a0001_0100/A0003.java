package a0001_0100;

import java.util.HashMap;

/**
 * created by srdczk 2019/11/6
 */
public class A0003 {
    class Solution {
        /**
         * 滑动窗口: 用一个哈希表记录每一个字母出现的位置,
         * 若果该字母上次出现的位置在窗口起始点之后,则移动窗口
         */
        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chs = s.toCharArray();
            for (int i = 0, j = 0; i < chs.length; i++) {
                if (map.containsKey(chs[i]) && map.get(chs[i]) >= j) {
                    j = map.get(chs[i]) + 1;
                }
                res = Math.max(res, i - j + 1);
                map.put(chs[i], i);
            }
            return res;
        }
    }
}
