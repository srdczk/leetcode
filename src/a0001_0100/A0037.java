package a0001_0100;

public class A0037 {
    class Solution {

        private boolean dfs(char[][] a) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (a[i][j] == '.') {
                        for (int k = 0; k < 9; k++) {
                            a[i][j] = (char)('1' + k);
                            if (can(a, i, j) && dfs(a)) return true;
                            a[i][j] = '.';
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        public void solveSudoku(char[][] a) {
            dfs(a);
        }
        private boolean can(char[][] a, int i, int j) {
            int[] cntX = new int[9], cntY = new int[9], cntZ = new int[9];
            for (int k = 0; k < 9; k++) {
                if (Character.isDigit(a[i][k]) && cntX[a[i][k] - '1']++ > 0) return false;
                if (Character.isDigit(a[k][j]) && cntY[a[k][j] - '1']++ > 0) return false;
                if (Character.isDigit(a[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3]) && cntZ[a[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] - '1']++ > 0) return false;
            }
            return true;
        }
    }
}
