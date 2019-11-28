package a0201_0300;

import java.util.PriorityQueue;

public class A0295 {
    class MedianFinder {
        // 数据流的中位数 <--> 一个最大堆, 一个最小堆
        /** initialize your data structure here. */
        // 最大堆 >= 最小堆
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i1 - i2);
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
            } else if (minHeap.size() == maxHeap.size()) {
                // 加入 maxHeap 中
                if (num >= minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else maxHeap.add(num);
            } else {
                // 加入 minHeap 中
                if (num <= maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else minHeap.add(num);
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else return maxHeap.peek();
        }
    }
}
