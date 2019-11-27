package a1101_1200;

import java.util.concurrent.Semaphore;

public class A1117 {
    class H2O {

        public H2O() {

        }
        private Semaphore s1 = new Semaphore(2), s2 = new Semaphore(0);
        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            s1.acquire();
            releaseHydrogen.run();
            s2.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            s2.acquire(2);
            releaseOxygen.run();
            s1.release(2);
        }
    }
}
