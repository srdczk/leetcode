package a0901_1000;
// Created by srdczk on 2020/1/3

import java.util.Map;
import java.util.TreeMap;

public class A0986 {

    class Solution {
        public int[][] intervalIntersection(int[][] a, int[][] b) {
            TreeMap<Integer, Integer> map = new TreeMap<>()
                    , res = new TreeMap<>();
            for (int[] c : b) map.put(c[0], c[1]);
            for (int[] c : a) {
                Map.Entry<Integer, Integer> begin = map.floorEntry(c[0]);
                if (begin == null) begin = map.ceilingEntry(c[0]);
                while (begin != null) {
                    if (begin.getKey() > c[1]) break;
                    int x = Math.max(c[0], begin.getKey()), y  = Math.min(begin.getValue(), c[1]);
                    if (x <= y) res.put(x, y);
                    begin = map.higherEntry(begin.getValue());
                }
            }
            int[][] p = new int[res.size()][2];
            int i = 0;
            for (int c : res.keySet()) {
                p[i][0] = c;
                p[i++][1] = res.get(c);
            }
            return p;
        }
    }

}
