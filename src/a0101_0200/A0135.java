package a0101_0200;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A0135 {
    class Solution {
        public int candy(int[] a) {
            int[] p = new int[a.length];
            Arrays.fill(p, 1);
            for (int i = 1; i < a.length; i++) {
                if (a[i] > a[i - 1]) p[i] = p[i - 1] + 1;
            }
            int sum = p[p.length - 1];
            for (int i = p.length - 2; i > -1; i--) {
                if (a[i] > a[i + 1] && p[i] <= p[i + 1]) p[i] = p[i + 1] + 1;
                sum += p[i];
            }
            return sum;
        }
    }
}
