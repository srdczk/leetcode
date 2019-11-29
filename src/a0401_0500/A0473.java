package a0401_0500;

import java.util.Arrays;

public class A0473 {
    class Solution {
        // 拼成正方形 <---> dfs
        private boolean dfs(int[] a, int[] k, int level, int len) {
            if (level == -1) {
                if (k[0] == k[1] && k[1] == k[2] && k[3] == k[2] && k[0] == len) return true;
                else return false;
            }
            for (int i = level; i > -1; i--) {
                for (int j = 0; j < 4; j++) {
                    if (k[j] + a[i] <= len) {
                        k[j] += a[i];
                        if (dfs(a, k, level - 1, len)) return true;
                        k[j] -= a[i];
                    }
                }
                // 如果没有能够插入的直接返回false,
                return false;
            }
            return false;
        }
        public boolean makesquare(int[] a) {
            if (a.length < 4) return false;
            int sum = 0;
            for (int c : a) sum += c;
            if (sum % 4 != 0) return false;
            for (int c : a) {
                if (c > sum / 4) return false;
            }
            Arrays.sort(a);
            return dfs(a, new int[4], a.length - 1, sum / 4);
        }
    }
}
