package a0201_0300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A0210 {
    class Solution {
        private List<Integer>[] adj;

        private int[] ins;

        private void init(int n) {
            ins = new int[n];
            adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public int[] findOrder(int n, int[][] ps) {
            init(n);
            for (int[] p : ps) {
                adj[p[1]].add(p[0]);
                ins[p[0]]++;
            }
            int[] res = new int[n];
            Queue<Integer> queue = new LinkedList<>();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (ins[i] == 0) {
                    res[cnt++] = i;
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int i = queue.poll();
                for (int q : adj[i]) {
                    if (--ins[q] == 0) {
                        queue.offer(q);
                        res[cnt++] = q;
                    }
                }
            }
            if (cnt != n) return new int[0];
            return res;
        }
    }
}
