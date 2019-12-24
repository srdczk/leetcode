package a0301_0400;

public class A0306 {
    class Solution {
        public boolean isAdditiveNumber(String num) {
            for (int i = 0; i < num.length() - 1; i++) {
                if (num.charAt(0) == '0' && i > 0) continue;
                for (int j = i + 1; j < num.length() - 1; j++) {
                    if (num.charAt(i + 1) == '0' && j > i + 1) continue;
                    long a = Long.parseLong(num.substring(0, i + 1));
                    long b = Long.parseLong(num.substring(i + 1, j + 1));
                    if (process(num.substring(j + 1), a, b)) return true;
                }
            }
            return false;
        }

        private boolean process(String remain, long a, long b) {
            if (remain.length() == 0) return true;
            long sum = a + b;
            String s = String.valueOf(a + b);
            return remain.startsWith(s) && process(remain.substring(s.length()), b, sum);
        }

    }
}
