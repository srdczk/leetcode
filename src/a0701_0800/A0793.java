package a0701_0800;

public class A0793 {
    class Solution {

        private long cnt(long x) {
            long p = 5, res = 0;
            while (x / p > 0) {
                res += x / p;
                p *= 5;
            }
            return res;
        }

        private boolean has(long k) {
            long begin = 0;
            long end = 40000000;
            end *= (long)100;
            end += (long)20;
            while (begin < end) {
                long mid = begin + ((end - begin) >> 1);
                long cnt = cnt(mid);
                if (cnt == k) return true;
                else if (cnt > k) end = mid - 1;
                else begin = mid + 1;
            }
            return cnt(begin) == k;
        }

        public int preimageSizeFZF(int x) {
            return has((long)x) ? 5 : 0;
        }
    }
}
