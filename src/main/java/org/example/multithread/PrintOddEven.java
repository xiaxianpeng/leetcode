package org.example.multithread;

import java.util.concurrent.Semaphore;

/**
 * 打印奇偶数
 * Created on 2025/1/16 10:00
 */
public class PrintOddEven {

    private static class ParityPrinter {
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

    private static class ParityPrinter2 {
        private final int max;
        private int count = 1;
        // 初始为1，奇数线程先获取
        private final Semaphore oddSemaphore = new Semaphore(1);
        // 初始为0，偶数线程等待
        private final Semaphore evenSemaphore = new Semaphore(0);

        public ParityPrinter2(int max) {
            this.max = max;
        }

        public void printOdd() {
            print(oddSemaphore, evenSemaphore);
        }

        public void printEven() {
            print(evenSemaphore, oddSemaphore);
        }

        private void print(Semaphore current, Semaphore next) {
            // 每个线程只会打印一半的数
            for (int i = 1; i <= max; i += 2) {
                try {
                    // 获取当前的信号量
                    current.acquire();
                    System.out.println(Thread.currentThread().getName() + " : " + count++);
                    // 释放下一个信号量
                    next.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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

        // 打印 1-100
        ParityPrinter printer2 = new ParityPrinter(100);
        // 创建打印奇数和偶数的线程
        Thread t3 = new Thread(printer2::printOdd, "Odd2");
        Thread t4 = new Thread(printer2::printEven, "Even2");
        t3.start();
        t4.start();
    }
}
