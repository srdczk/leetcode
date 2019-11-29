package a0601_0700;

public class A0679 {
    class Solution {
        private boolean isZero(double a) {
            return Math.abs(a) < 1e-6;
        }
        private boolean process(double[] a, int n) {
            if (n == 1) return isZero(a[0] - 24);
            double[] b = new double[n - 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int m = 0;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) b[m++] = a[k];
                    }
                    b[m] = a[i] + a[j];
                    if (process(b, n - 1)) return true;
                    b[m] = a[i] * a[j];
                    if (process(b, n - 1)) return true;
                    b[m] = a[i] - a[j];
                    if (process(b, n - 1)) return true;
                    b[m] = a[j] - a[i];
                    if (process(b, n - 1)) return true;
                    if (!isZero(a[i])) {
                        b[m] = a[j] / a[i];
                        if (process(b, n - 1)) return true;
                    }
                    if (!isZero(a[j])) {
                        b[m] = a[i] / a[j];
                        if (process(b, n - 1)) return true;
                    }
                }
            }
            return false;
        }
        public boolean judgePoint24(int[] a) {
            double[] b = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            return process(b, b.length);
        }
    }
}
