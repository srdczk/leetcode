package a0201_0300;

public class A0201 {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            // 只需要求前缀即可
            int cnt = 0;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                cnt++;
            }
            return n << cnt;
        }
    }

}
