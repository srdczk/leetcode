package a0401_0500;

public class A0419 {
    class Solution {
        private char[][] a;
        private int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};
        private void dfs(int i, int j) {
            a[i][j] = '.';
            for (int k = 0; k < x.length; k++) {
                int tx = i + x[k], ty = j + y[k];
                if (tx > -1 && tx < a.length && ty > -1 && ty < a[0].length && a[tx][ty] == 'X') {
                    dfs(tx, ty);
                }
            }
        }
        public int countBattleships(char[][] board) {
            if (board.length == 0 || board[0].length == 0) return 0;
            a = board;
            int res = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == 'X') {
                        res++;
                        dfs(i, j);
                    }
                }
            }
            return res;
        }
    }
}
