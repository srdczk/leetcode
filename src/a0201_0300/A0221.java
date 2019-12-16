package a0201_0300;

public class A0221 {
    class Solution {
        public int maximalSquare(char[][] a) {
            if (a.length == 0 || a[0].length == 0) return 0;
            int[][] hs = new int[a.length][a[0].length];
            for (int i = 0; i < a[0].length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (a[j][i] == '0') hs[j][i] = 0;
                    else if (j == 0) hs[j][i] = 1;
                    else hs[j][i] = hs[j - 1][i] + 1;
                }
            }
            int res = 0;
            for (int[] c : hs) {
                int[] rightMin = new int[c.length];
                int[] leftMin = new int[c.length];
                leftMin[0] = -1;
                rightMin[rightMin.length - 1] = rightMin.length;
                for (int i = 1; i < leftMin.length; i++) {
                    int k = i - 1;
                    while (k > -1 && c[k] >= c[i]) k = leftMin[k];
                    leftMin[i] = k;
                    //rightMin - 1 - i
                    k = rightMin.length - 1 - i;
                    int p = k + 1;
                    while (p < rightMin.length && c[p] >= c[k]) p = rightMin[p];
                    rightMin[k] = p;
                }
                for (int i = 0; i < c.length; i++) {
                    int len = rightMin[i] - leftMin[i] - 1;
                    int min = Math.min(len, c[i]);
                    res = Math.max(res, min * min);
                }
            }
            return res;
        }
    }
}
