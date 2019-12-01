package a0201_0300;

public class A0264 {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] res = new int[n];
            res[0] = 1;
            int i = 1, x = 0, y = 0, z = 0;
            while (i < n) {
                res[i++] = Math.min(res[x] * 2, Math.min(res[y] * 3, res[z] * 5));
                if (res[x] * 2 == res[i - 1]) x++;
                if (res[y] * 3 == res[i - 1]) y++;
                if (res[z] * 5 == res[i - 1]) z++;
            }
            return res[n - 1];
        }
    }
}
