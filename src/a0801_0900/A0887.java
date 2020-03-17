package a0801_0900;

import java.util.Arrays;

/**
 * create by srdczk 20-3-17
 */
public class A0887 {
    class Solution {
        public int superEggDrop(int k, int n) {
            // k 个鸡蛋, m 次移动能测算的最大高度
            // x[m][k] = x[m - 1][k](如果没碎) + x[m - 1][k - 1]如果碎了 + 1(本层)
            int[] record = new int[k + 1];
            Arrays.fill(record, 1);
            record[0] = 0;
            int res = 2;
            while (record[k] < n) {
                for (int i = k; i > 0; i--) {
                    record[i] += (1 + record[i - 1]);
                }
                res++;
            }
            return res - 1;
        }
    }
}
