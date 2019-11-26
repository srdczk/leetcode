package a1101_1200;

import java.util.concurrent.Semaphore;

public class A1115 {
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }
        // 准备两个信号量, 控制交替打印
        private Semaphore s1 = new Semaphore(1), s2 = new Semaphore(0);
        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                // 第一个必须他
                s1.acquire();
                printFoo.run();
                s2.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                s2.acquire();
                printBar.run();
                s1.release();
            }
        }
    }
}
