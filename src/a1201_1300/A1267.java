package a1201_1300;
// Created by srdczk on 2020/1/6

import java.util.Arrays;

public class A1267 {
    class Solution {
        private int[] f, cnt;
        private void init(int n) {
            f = new int[n];
            cnt = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
                cnt[i] = 1;
            }
        }
        private int findFather(int i) {
            int t = i;
            while (f[i] != i) {
                i = f[i];
            }
            while (t != i) {
                int tmp = f[t];
                f[t] = i;
                t = tmp;
            }
            return i;
        }

        private void union(int i, int j) {
            int fi = findFather(i), fj = findFather(j);
            if (fi != fj) {
                f[fi] = fj;
                cnt[fj] += cnt[fi];
            }
        }

        public int countServers(int[][] a) {
            if (a.length == 0 || a[0].length == 0) return 0;
            init(a.length * a[0].length);
            int[] ci = new int[a.length], cj = new int[a[0].length];
            Arrays.fill(ci, -1);
            Arrays.fill(cj, -1);
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == 1) {
                        if (ci[i] == -1) {
                            ci[i] = i * a[0].length + j;
                        } else {
                            union(i * a[0].length + j, ci[i]);
                        }
                        if (cj[j] == -1) {
                            cj[j] = i * a[0].length + j;
                        } else {
                            union(i * a[0].length + j, cj[j]);
                        }
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == 1){
                        if (cnt[findFather(i * a[0].length + j)] > 1) res++;
                        //res++;
                    }
                }
            }
            return res;
        }
    }
}
