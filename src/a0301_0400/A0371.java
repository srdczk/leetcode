package a0301_0400;

/**
 * create by srdczk 20-2-28
 */
public class A0371 {
    class Solution {
        public int getSum(int a, int b) {
            // 不用 加法 实现
            // a + b  = (a ^ b) + (a & b) << 1; -> 亦或 无进位 (a & b) 相同地方为1并且进位
            if (a == 0 || b == 0) return a == 0 ? b : a;
            return getSum(a ^ b, (a & b) << 1);
        }
    }
}
