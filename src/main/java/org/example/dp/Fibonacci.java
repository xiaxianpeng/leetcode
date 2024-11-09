package org.example.dp;

/**
 * 斐波那契数
 * f(n) = 1 , n = 1,2
 * f(n) = f(n - 1) + f(n - 2)
 * Created on 2024/11/9 22:07
 */
public class Fibonacci {
    int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        // base case;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 根据斐波那契数列的状态转移方程，
     * 当前状态只和之前的两个状态有关，
     * 其实并不需要那么长的一个 DP table 来存储所有的状态，
     * 只要想办法存储之前的两个状态就行了。
     */
    int fibOptimized(int n) {
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println("n=" + n + ",fib=" + new Fibonacci().fib(n));
    }
}
