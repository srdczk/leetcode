package a1101_1200;

public class A1114 {
    class Foo {

        public Foo() {

        }
        // 线程之间可见
        private volatile int i = 0;
        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            while (i != 0);
            printFirst.run();
            i++;
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while (i != 1);
            printSecond.run();
            i++;
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while (i != 2);
            printThird.run();
            i++;
        }
    }
}
