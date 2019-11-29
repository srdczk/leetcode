package a0601_0700;

public class A0640 {
    class Solution {
        private int[] process(String s) {
            int[] res = new int[2];
            int i = 0, x = 0, p = 1;
            boolean b = false;
            char[] chs = s.toCharArray();
            while (i < chs.length) {
                if (chs[i] == '+' || chs[i] == '-') {
                    res[1] += p * x;
                    if (chs[i] == '+') p = 1;
                    else p = -1;
                    x = 0;
                    b = false;
                } else if (chs[i] == 'x') {
                    if (x == 0) {
                        if (!b) res[0] += p;
                    } else res[0] += p * x;
                    x = 0;
                } else {
                    x = x * 10 + chs[i] - '0';
                    b = true;
                }
                i++;
            }
            if (x != 0) res[1] += p * x;
            return res;
        }
        public String solveEquation(String s) {
            String[] ss = s.split("=");
            int[] x = process(ss[0]), y = process(ss[1]);
            if (x[0] == y[0]) {
                if (x[1] == y[1]) return "Infinite solutions";
                else return "No solution";
            } else if (x[1] == y[1]){
                return "x=0";
            } else {
                return "x=" + String.valueOf((y[1] - x[1]) / (x[0] - y[0]));
            }
        }
    }
}
