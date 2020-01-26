package a1101_1200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class A1188 {
    class BoundedBlockingQueue {
        private Semaphore x, y;
        private Deque<Integer> deque = new LinkedList<>();
        public BoundedBlockingQueue(int capacity) {
            x = new Semaphore(capacity);
            y = new Semaphore(0);
        }

        public void enqueue(int element) throws InterruptedException {
            x.acquire();
            deque.addLast(element);
            y.release();
        }

        public int dequeue() throws InterruptedException {
            y.acquire();
            int res = deque.pollFirst();
            x.release();
            return res;
        }

        public int size() {
            return deque.size();
        }
    }
}
