package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0057 {
    class Solution {
        public int[][] insert(int[][] as, int[] a) {
            int start = a[0], end = a[1];
            List<int[]> res = new ArrayList<>();
            for (int[] c : as) {
                if (c[0] > end) {
                    res.add(new int[] {start, end});
                    start = c[0];
                    end = c[1];
                } else if (c[1] < start) {
                    res.add(c);
                } else {
                    start = Math.min(c[0], start);
                    end = Math.max(c[1], end);
                }
            }
            res.add(new int[] {start, end});
            return res.toArray(new int[][] {});
        }
    }
}
