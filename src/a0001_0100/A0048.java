package a0001_0100;

public class A0048 {
    class Solution {
        public void rotate(int[][] a) {
            // 每次转一圈
            if (a.length < 2) return;
            // 一共有 a.length / 2 圈
            for (int i = 0; i < a.length / 2; i++) {
                // 每一圈 考虑 a.length - 2 * i -1 个元素
                // 起始元素 i
                for (int j = i; j < a.length - i - 1; j++) {
                    int x = i, y = j, next_x = y, next_y = a.length - 1 - x, cur = a[x][y];
                    // 转一圈
                    while (true) {
                        int tmp = a[next_x][next_y];
                        a[next_x][next_y] = cur;
                        x = next_x;
                        y = next_y;
                        next_x = y;
                        next_y = a.length - 1 - x;
                        cur = tmp;
                        if (x == i && y == j) break;
                    }
                }
            }
        }
    }
}
