package a1201_1300;
// Created by srdczk on 2020/1/5

import java.util.Arrays;

public class A1288 {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (x, y) -> {
                if (x[0] != y[0]) return x[0] - y[0];
                else return y[1] - x[1];
            });
            int max = Integer.MIN_VALUE, cnt = 0;
            for (int[] interval : intervals) {
                if (max < interval[1]) {
                    max = interval[1];
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
