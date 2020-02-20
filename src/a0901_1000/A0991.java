package a0901_1000;

import java.util.HashMap;

/**
 * create by srdczk 20-2-12
 */
public class A0991 {
    class Solution {
        public int brokenCalc(int x, int y) {
            if (x >= y) {
                return x - y;
            }
            // 如果 y 是整数, 一定 是 某个数字 * 2 得来
            if (y % 2 == 0) return brokenCalc(x, y / 2) + 1;
            return brokenCalc(x, (y + 1) / 2) + 2;
        }
    }
}
