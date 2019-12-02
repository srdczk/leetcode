package a0001_0100;

public class A0036 {
    class Solution {
        public boolean isValidSudoku(char[][] a) {
            for (int i = 0; i < 9; i++) {
                int[] cntX = new int[10], cntY = new int[10], cntZ = new int[10];
                for (int j = 0; j < 9; j++) {
                    if (Character.isDigit(a[i][j]) && cntX[a[i][j] - '0']++ > 0) return false;
                    if (Character.isDigit(a[j][i]) && cntY[a[j][i] - '0']++ > 0) return false;
                    // 每个点 <>
                    if (Character.isDigit(a[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]) && cntZ[a[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] - '0']++ > 0) return false;
                }
            }
            return true;
        }
    }
}
