package a0701_0800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class A0787 {
    class Solution {
        private class Node {
            public int v, dis;

            public Node(int v, int dis) {
                this.v = v;
                this.dis = dis;
            }
        }
        private HashMap<Integer, List<Node>> map = new HashMap<>();
        public int findCheapestPrice(int n, int[][] fs, int s, int d, int k) {
            for (int[] f : fs) {
                if (!map.containsKey(f[0])) map.put(f[0], new ArrayList<>());
                map.get(f[0]).add(new Node(f[1], f[2]));
            }
            // dis -> 0
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            queue.offer(new int[]{0, s, k + 1});
            while (!queue.isEmpty()) {
                int[] c = queue.poll();
                if (c[1] == d) return c[0];
                if (c[2] > 0 && map.containsKey(c[1])) {
                    for (Node node : map.get(c[1])) {
                        queue.offer(new int[] {node.dis + c[0], node.v, c[2] - 1});
                    }
                }
            }
            return -1;
        }
    }
}
