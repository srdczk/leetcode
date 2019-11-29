package a0401_0500;

import org.omg.CORBA.INTERNAL;

import java.util.PriorityQueue;

public class A0480 {
    class Solution {
        private class Median {
            private PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> {
                if (i1 > i2) return 1;
                else if (i1.equals(i2)) return 0;
                else return -1;
            });
            private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> {
                if (i1 > i2) return -1;
                else if (i2.equals(i1)) return 0;
                else return 1;
            });
            // maxHeap 的值, == 1 + minHeap.size() || == minHeap.size()
            public void add(int a) {
                if (maxHeap.size() == 0) maxHeap.add(a);
                else if (maxHeap.size() == minHeap.size()) {
                    if (a > minHeap.peek()) {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(a);
                    } else maxHeap.add(a);
                } else {
                    if (a < maxHeap.peek()) {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(a);
                    } else minHeap.add(a);
                }
            }
            public double median() {
                if (maxHeap.size() == minHeap.size()) return (double)((long)maxHeap.peek() + (long)minHeap.peek()) / 2.0;
                else return maxHeap.peek();
            }
            public void remove(int a) {
                if (maxHeap.size() == minHeap.size()) {
                    if (a >= minHeap.peek()) minHeap.remove(a);
                    else {
                        maxHeap.remove(a);
                        maxHeap.add(minHeap.poll());
                    }
                } else {
                    if (a <= maxHeap.peek()) maxHeap.remove(a);
                    else {
                        minHeap.remove(a);
                        minHeap.add(maxHeap.poll());
                    }
                }
            }
        }
        // 滑动窗口的中位数 <---> 构造两个滑动窗口, 并且求其最大最小值
        // 用数据流的中位数 类似解法
        public double[] medianSlidingWindow(int[] a, int k) {
            Median median = new Median();
            double[] res = new double[a.length - k + 1];
            for (int i = 0; i < k; i++) median.add(a[i]);
            for (int i = 0; i < res.length; i++) {
                res[i] = median.median();
                median.remove(a[i]);
                // c++ 系统设计
                if (i != res.length - 1) median.add(a[i + k]);
            }
            return res;
        }
    }
}
