package a0401_0500;

public class A0413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] a) {
            if (a.length < 3) return 0;
            int res = 0;
            int i = 2;
            while (i < a.length) {
                Integer c = null;
                int begin = i;
                if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) c = a[i] - a[i - 1];
                if (c != null) {
                    while (i < a.length && c.equals(a[i] - a[i - 1])) i++;
                    res += (1 + i - begin) * (i - begin) / 2;
                } else i++;
            }
            return res;
        }
    }
}
