package a1101_1200;

public class A1131 {
    class Solution {
        // 一共 8 种可能
        // x[i] - x[j] + y[i] - y[j] + i - j
        // x[i] - x[j] + y[j] - y[i] + i - j
        // x[i] - x[j] + y[i] - y[j] + j - i
        // x[i] - x[j] + y[j] - y[i] + j - i
        // x[j] - x[i] + y[i] - y[j] + i - j
        // x[j] - x[i] + y[j] - y[i] + i - j
        // x[j] - x[i] + y[i] - y[j] + j - i
        // x[j] - x[i] + y[j] - y[i] + j - i
        // i j 聚在一起, 对称
        // (x[i] + y[i] + i) - (y[j] + x[j] + j)
        // x[i] - y[i] + i - (x[j] - y[j] + j)
        // x[i] + y[i] - i - (y[j] + x[j] - j)
        // x[i] - y[i] - i - (x[j] - y[j] - j)
        public int maxAbsValExpr(int[] x, int[] y) {
            int aMax = Integer.MIN_VALUE, aMin = Integer.MAX_VALUE;
            int bMax = Integer.MIN_VALUE, bMin = Integer.MAX_VALUE;
            int cMax = Integer.MIN_VALUE, cMin = Integer.MAX_VALUE;
            int dMax = Integer.MIN_VALUE, dMin = Integer.MAX_VALUE;
            for (int i = 0; i < x.length; i++) {
                aMax = Math.max(x[i] + y[i] + i, aMax);
                aMin = Math.min(x[i] + y[i] + i, aMin);
                bMax = Math.max(x[i] - y[i] + i, bMax);
                bMin = Math.min(x[i] - y[i] + i, bMin);
                cMax = Math.max(x[i] - y[i] - i, cMax);
                cMin = Math.min(x[i] - y[i] - i, cMin);
                dMax = Math.max(x[i] + y[i] - i, dMax);
                dMin = Math.min(y[i] + x[i] - i, dMin);
            }
            return Math.max(Math.max(aMax - aMin, bMax - bMin), Math.max(cMax - cMin, dMax - dMin));
        }
    }
}
