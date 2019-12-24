package a0801_0900;

import java.util.ArrayList;
import java.util.List;

public class A0842 {
    class Solution {

        private List<Integer> res = new ArrayList<>();

        public List<Integer> splitIntoFibonacci(String s) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(0) == '0' && i > 0) continue;
                for (int j = i + 1; j < s.length() - 1; j++) {
                    if (s.charAt(i + 1) == '0' && j > i + 1) continue;
                    if (i + 1 > 12 || j - i > 12) continue;
                    long a = Long.parseLong(s.substring(0, i + 1));
                    long b = Long.parseLong(s.substring(i + 1, j + 1));
                    if (a <= (long)Integer.MAX_VALUE
                            && b <= (long)Integer.MAX_VALUE
                            && (a + b) >= 0 && (a + b) <= (long)Integer.MAX_VALUE) {
                        res.add((int) a);
                        res.add((int) b);
                        if (process(s.substring(j + 1), a, b)) return res;
                        res.clear();
                    }
                }
            }
            return res;
        }
        private boolean process(String remain, long i, long j) {
            if (remain.length() == 0) return true;
            long sum = i + j;
            String s = String.valueOf(sum);
            if (!(i >= 0
                    && j >= 0
                    && sum >= 0
                    && i <= (long)Integer.MAX_VALUE
                    && j <= (long) Integer.MAX_VALUE
                    && sum <= (long)Integer.MAX_VALUE
                    && remain.startsWith(s))) return false;
            res.add((int) sum);
            return process(remain.substring(s.length()), j, sum);
        }
    }
}
