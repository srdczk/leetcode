package a0401_0500;

import java.util.Arrays;

public class A0452 {
    class Solution {
        public int findMinArrowShots(int[][] a) {
            if (a.length == 0) return 0;
            Arrays.sort(a, (x, y) -> x[1] - y[1]);
            int cnt = 1, max = a[0][1];
            for (int[] c : a) {
                if (c[0] > max) {
                    cnt++;
                    max = c[1];
                }
            }
            return cnt;
        }
    }
}
