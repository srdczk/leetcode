package a1101_1200;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class A1195 {
    class FizzBuzz {
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }
        private volatile int cnt = 1;
        // printFizz.run() outputs "fizz".
        private Semaphore a = new Semaphore(1), b = new Semaphore(0), c = new Semaphore(0), d = new Semaphore(0);
        public void fizz(Runnable printFizz) throws InterruptedException {

            for (int i = 0; i < ((n / 3) - (n / 15)); i++) {
                b.acquire();
                printFizz.run();
                cnt++;
                a.release();
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 0; i < ((n / 5) - (n / 15)); i++) {
                c.acquire();
                printBuzz.run();
                cnt++;
                a.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 0; i < n / 15; i++) {
                d.acquire();
                printFizzBuzz.run();
                cnt++;
                a.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i < n + 1; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    a.acquire();
                    d.release();
                } else if (i % 3 == 0) {
                    a.acquire();
                    b.release();
                } else if (i % 5 == 0) {
                    a.acquire();
                    c.release();
                } else {
                    printNumber.accept(cnt++);
                }
            }
        }
    }
}
