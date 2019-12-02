package a0201_0300;

public class A0233 {
    class Solution {
        private long res(long n) {
            if (n == 0) return 0;
            if (n < 10) return 1;
            long len = String.valueOf(n).length();
            long x = (long) Math.pow(10, len - 1);
            long first = n / x;
            long firstNum = first == 1 ? n % x + 1 : x;
            long otherNum = first * (x / 10) * (len - 1);
            return firstNum + otherNum + res(n % (first * x));
        }
        public int countDigitOne(int n) {
            if (n <= 0) return 0;
            return (int) res(n);
        }
    }
}
