package a1201_1300;

import java.util.HashMap;

public class A1218 {
    class Solution {
        private HashMap<Integer, Integer> map = new HashMap<>();
        public int longestSubsequence(int[] a, int d) {
            int res = 0;
            for (int c : a) {
                int p = map.getOrDefault(c - d, 0) + 1;
                map.put(c, p);
                res = Math.max(res, p);
            }
            return res;
        }
    }
}
