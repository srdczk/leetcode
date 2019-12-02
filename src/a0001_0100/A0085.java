package a0001_0100;

public class A0085 {
    // 单调栈
    class Solution {
        public int maximalRectangle(char[][] a) {
            if (a.length == 0 || a[0].length == 0) return 0;
            int[][] hs = new int[a.length][a[0].length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == '0') hs[i][j] = 0;
                    else if (i == 0) hs[i][j] = 1;
                    else hs[i][j] = hs[i - 1][j] + 1;
                }
            }
            int res = 0;
            for (int[] c : hs) {
                int[] leftMin = new int[c.length], rightMin = new int[c.length];
                rightMin[rightMin.length - 1] = rightMin.length;
                leftMin[0] = -1;
                for (int i = 1; i < leftMin.length; i++) {
                    int k = i - 1;
                    while (k > -1 && c[k] >= c[i]) k = leftMin[k];
                    leftMin[i] = k;
                }
                for (int i = rightMin.length - 1; i > -1; i--) {
                    int k = i + 1;
                    while (k < rightMin.length && c[k] >= c[i]) k = rightMin[k];
                    rightMin[i] = k;
                }
                for (int i = 0; i < c.length; i++) {
                    res = Math.max((rightMin[i] - leftMin[i] - 1) * c[i], res);
                }
            }
            return res;
        }
    }
}
