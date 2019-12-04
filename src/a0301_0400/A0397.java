package a0301_0400;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class A0397 {
    class Solution {
        public int integerReplacement(int n) {
            if (n == 1) return 0;
            if (n == Integer.MAX_VALUE) return 32;
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(n);
            map.put(n, 0);
            while (!queue.isEmpty()) {
                int k = queue.poll();
                if (k % 2 == 1) {
                    if (!map.containsKey(k + 1)) {
                        if (k + 1 == 1) return map.get(k) + 1;
                        map.put(k + 1, map.get(k) + 1);
                        queue.offer(k + 1);
                    }
                    if (!map.containsKey(k - 1)) {
                        if (k - 1 == 1) return map.get(k + 1);
                        map.put(k - 1, map.get(k) + 1);
                        queue.offer(k - 1);
                    }
                } else {
                    if (!map.containsKey(k / 2)) {
                        if (k / 2 == 1) return map.get(k) + 1;
                        map.put(k / 2, map.get(k) + 1);
                        queue.offer(k / 2);
                    }
                }
            }
            return -1;
        }
    }
}
