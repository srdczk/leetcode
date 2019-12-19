package a0101_0200;

import java.util.Arrays;

public class A0179 {
    class Solution {
        public String largestNumber(int[] a) {
            Integer[] p = new Integer[a.length];
            for (int i = 0; i < p.length; i++) {
                p[i] = a[i];
            }
            Arrays.sort(p, (x, y) -> {
                StringBuilder i = new StringBuilder(), j = new StringBuilder();
                i.append(x).append(y);
                j.append(y).append(x);
                return j.toString().compareTo(i.toString());
            });
            StringBuilder res = new StringBuilder();
            for (Integer c : p) res.append(c);
            int i = 0;
            while (i < res.length() && res.charAt(i) == '0') i++;
            return i == res.length() ? "0" : res.toString().substring(i);
        }
    }
}
