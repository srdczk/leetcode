package a0201_0300;

public class A0260 {
    class Solution {
        public int[] singleNumber(int[] a) {
            int[] res = new int[2];
            int sum = 0, k = 0;
            for (int c : a) sum ^= c;
            int rightOne = (~sum + 1) & sum;
            for (int c : a) {
                if ((c & rightOne) > 0) k ^= c;
            }
            res[0] = k;
            res[1] = sum ^ k;
            return res;
        }
    }
}
