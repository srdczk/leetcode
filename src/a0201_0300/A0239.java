package a0201_0300;

import java.util.Deque;
import java.util.LinkedList;

public class A0239 {
    class Solution {
        public int[] maxSlidingWindow(int[] a, int k) {
            if (a.length == 0) return a;
            int[] res = new int[a.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < a.length; i++) {
                while (!deque.isEmpty() && a[deque.peekLast()] <= a[i]) deque.pollLast();
                deque.addLast(i);
                if (deque.peekFirst() == i - k) deque.pollFirst();
                if (i >= k - 1) res[i - k + 1] = a[deque.peekFirst()];
            }
            return res;
        }
    }
}
