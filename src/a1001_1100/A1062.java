package a1001_1100;
// Created by srdczk on 2020/1/15

import java.util.HashSet;

public class A1062 {
    class Solution {
        private boolean search(String s, int len) {
            for (int j = 0; j < s.length() - len + 1; j++) {
                if (s.lastIndexOf(s.substring(j, j + len)) != j) return true;
            }
            return false;
        }
        public int longestRepeatingSubstring(String s) {
            int left = 1, right = s.length() - 1, lastPos = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (search(s, mid)) {
                    lastPos = mid;
                    left = mid + 1;
                } else right = mid - 1;
            }
            return lastPos;
        }
    }
}
