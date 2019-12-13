package a0101_0200;

public class A0137 {
    class Solution {
        public int singleNumber(int[] a) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                int k = 0;
                for (int c : a) {
                    k += (c >> i) & 1;
                }
                if (k % 3 == 1) res |= (1 << i);
            }
            return res;
        }
    }
}
