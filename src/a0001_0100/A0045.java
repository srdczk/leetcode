package a0001_0100;

public class A0045 {
    // 一个数记录下一步能到达的最大值, 一个数记录本次能到达的最大值
    class Solution {
        public int jump(int[] a) {
            if (a.length == 1) return 0;
            int step = 0, cur = 0, next = 0;
            for (int i = 0; i < a.length; i++) {
                next = Math.max(next, a[i] + i);
                if (next >= a.length - 1) return step + 1;
                if (cur == i) {
                    cur = next;
                    step++;
                }
            }
            return step;
        }
    }
}
