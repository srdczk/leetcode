package a0301_0400;

import java.util.Deque;
import java.util.LinkedList;

public class A0321 {
    class Solution {

        private int[] process(int[] a, int k) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < a.length; i++) {
                while (!deque.isEmpty()
                        && deque.peekLast() < a[i]
                        && deque.size() + a.length - i > k) deque.pollLast();
                deque.addLast(a[i]);
            }
            int i = 0, res[] = new int[k];
            for (int c : deque) {
                if (i == k) return res;
                res[i++] = c;
            }
            return res;
        }
        private boolean pd(int[] x, int i, int[] y, int j) {
            while (i < x.length && j < y.length) {
                if (x[i] == y[j]) {
                    i++;
                    j++;
                } else return x[i] > y[j];
            }
            return j == y.length;
        }
        public int[] maxNumber(int[] a, int[] b, int k) {
            int[] res = new int[k];
            // 一共 k 个数
            for (int i = 0; i < k + 1; i++) {
                if (i > a.length || k - i > b.length) continue;
                int[] x = process(a, i), y = process(b, k - i);
                int p = 0, q = 0, j = 0;
                int[] tmp = new int[k];
                while (p < x.length && q < y.length) {
                    if (x[p] > y[q]) tmp[j++] = x[p++];
                    else if (x[p] < y[q]) tmp[j++] = y[q++];
                    else {
                        if (pd(x, p + 1, y, q + 1)) tmp[j++] = x[p++];
                        else tmp[j++] = y[q++];
                    }
                }
                while (p < x.length) tmp[j++] = x[p++];
                while (q < y.length) tmp[j++] = y[q++];
                if (pd(tmp, 0, res, 0)) res = tmp;
            }
            return res;
        }
    }
}
