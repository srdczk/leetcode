package a1301_1400;
// Created by srdczk on 2020/1/5

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class A1306 {
    class Solution {
        public boolean canReach(int[] arr, int start) {
            if (start < 0 || start > arr.length - 1) return false;
            if (arr[start] == 0) return true;
            HashSet<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            set.add(start);
            while (!queue.isEmpty()) {
                int c = queue.poll();
                if (c + arr[c] < arr.length && !set.contains(c + arr[c])) {
                    if (arr[c + arr[c]] == 0) return true;
                    queue.offer(c + arr[c]);
                    set.add(c + arr[c]);
                }
                if (c - arr[c] > -1 && !set.contains(c - arr[c])) {
                    if (arr[c - arr[c]] == 0) return true;
                    queue.offer(c - arr[c]);
                    set.add(c - arr[c]);
                }
            }
            return false;
        }
    }
}
