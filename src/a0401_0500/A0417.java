package a0401_0500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0417 {
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private boolean[][] visA, visB;
        private int[][] p;
        private int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};
        private void dfsA(int i, int j) {
            if (visA[i][j]) return;
            visA[i][j] = true;
            for (int k = 0; k < x.length; k++) {
                int tx = i + x[k], ty = j + y[k];
                if (tx > -1 && tx < visA.length && ty > -1 && ty < visA[0].length && p[tx][ty] >= p[i][j] && !visA[tx][ty]) {
                    dfsA(tx, ty);
                }
            }
        }
        private void dfsB(int i, int j) {
            if (visB[i][j]) return;
            visB[i][j] = true;
            if (visA[i][j]) res.add(new ArrayList<>(Arrays.asList(i, j)));
            for (int k = 0; k < x.length; k++) {
                int tx = i + x[k], ty = j + y[k];
                if (tx > -1 && tx < visB.length && ty > -1 && ty < visB[0].length && p[tx][ty] >= p[i][j] && !visB[tx][ty]) {
                    dfsB(tx, ty);
                }
            }
        }
        public List<List<Integer>> pacificAtlantic(int[][] a) {
            if (a.length == 0 || a[0].length == 0) return res;
            p = a;
            visA = new boolean[a.length][a[0].length];
            visB = new boolean[a.length][a[0].length];
            for (int i = 0; i < Math.max(a.length, a[0].length); i++) {
                if (i < a.length) dfsA(i, 0);
                if (i < a[0].length) dfsA(0, i);
            }
            for (int i = 0; i < Math.max(a.length, a[0].length); i++) {
                if (i < a.length) dfsB(i, a[0].length - 1);
                if (i < a[0].length) dfsB(a.length - 1, i);
            }
            return res;
        }
    }
}
