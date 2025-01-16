package org.example.multithread;

/**
 * 打印奇偶数
 * Created on 2025/1/16 10:00
 */
public class PrintOddEven {

    public static class ParityPrinter {
        private final int max;
        private int count = 1;
        private final Object lock = new Object();

        public ParityPrinter(int max) {
            this.max = max;
        }

        public void printOdd() {
            print(true);
        }

        public void printEven() {
            print(false);
        }

        private void print(boolean isOdd) {
            // 每个线程只会打印一半的数
            for (int i = 1; i <= max; i += 2) {
                synchronized (lock) {
                    // 当线程希望打印的与当前count的奇偶性不符，则等待
                    while (isOdd == (count % 2 == 0)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + count++);
                    // 打印完成后，通知另一个线程
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 打印 1-100
        ParityPrinter printer = new ParityPrinter(100);
        // 创建打印奇数和偶数的线程
        Thread t1 = new Thread(printer::printOdd, "Odd");
        Thread t2 = new Thread(printer::printEven, "Even");
        t1.start();
        t2.start();
    }
}
