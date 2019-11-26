package a1101_1200;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class A1116 {
    class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }
        private volatile int cnt = 0;
        private Semaphore a = new Semaphore(1), b = new Semaphore(0), c = new Semaphore(0);
        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                a.acquire();
                printNumber.accept(0);
                cnt++;
                if (cnt % 2 == 1) b.release();
                else c.release();
            }
        }



        public void even(IntConsumer printNumber) throws InterruptedException {
            // 偶数一共有 (n / 2) 个
            for (int i = 0; i < n / 2; i++) {
                c.acquire();
                printNumber.accept(cnt);
                a.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            // 奇数一共有 (n + 1) / 2 个
            for (int i = 0; i < (n + 1) / 2; i++) {
                b.acquire();
                printNumber.accept(cnt);
                a.release();
            }
        }
    }
}
