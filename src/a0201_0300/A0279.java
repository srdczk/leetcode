package a0201_0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A0279 {
    // bfs 求解
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                int k = queue.poll();
                for (int i = 1; i * i + k < n + 1; i++) {
                    if (dp[i * i + k] == 0) {
                        if (i * i + k == n) return dp[k] + 1;
                        dp[i * i + k] = dp[k] + 1;
                        queue.offer(i * i + k);
                    }
                }
            }
            return dp[n];
        }
    }
}
