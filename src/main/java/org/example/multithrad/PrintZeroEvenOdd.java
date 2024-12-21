package org.example.multithrad;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
 * 例如，调用 printNumber(7) 将会输出 7 到控制台。
 * 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
 * 线程 A：调用 zero() ，只输出 0
 * 线程 B：调用 even() ，只输出偶数
 * 线程 C：调用 odd() ，只输出奇数
 * 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
 * 实现 ZeroEvenOdd 类：
 * ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
 * void zero(printNumber) 调用 printNumber 以输出一个 0 。
 * void even(printNumber) 调用printNumber 以输出偶数。
 * void odd(printNumber) 调用 printNumber 以输出奇数。
 * 示例 1：
 * 输入：n = 2
 * 输出："0102"
 * 解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * 输入：n = 5
 * 输出："0102030405"
 * Created on 2024/12/21 17:18
 */
public class PrintZeroEvenOdd {

    private int n;
    Semaphore zeroSemaphore = new Semaphore(1);// 控制zero线程
    Semaphore oddSemaphore = new Semaphore(0);// 控制odd线程
    Semaphore evenSemaphore = new Semaphore(0);// 控制even线程

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();// 获取信号量，确保是该线程执行
            printNumber.accept(0);//打印0
            if (i % 2 == 0) {
                evenSemaphore.release();//偶数时，唤醒even线程
            } else {
                oddSemaphore.release();//奇数时，唤醒odd线程
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            oddSemaphore.acquire();//等待零或偶数线程唤醒
            printNumber.accept(i);//打印奇数
            zeroSemaphore.release();//唤醒zero线程
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            evenSemaphore.acquire();//等待零线程唤醒
            printNumber.accept(i);//打印偶数
            zeroSemaphore.release();//唤醒zero线程
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd printZeroEvenOdd = new PrintZeroEvenOdd(5);
        Thread t1 = new Thread(() -> {
            try {
                printZeroEvenOdd.zero(System.out::print); // 线程 A 执行 zero
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printZeroEvenOdd.even(System.out::print); // 线程 B 执行 even
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                printZeroEvenOdd.odd(System.out::print); // 线程 C 执行 odd
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }

}
