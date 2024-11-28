package org.example.bit;

/**
 * 实现整数除法，使用减法和位操作来模拟除法过程。
 */
public class Divide {

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return 商
     * 使用减法和位移操作代替除法。
     */
    public static int divide(int dividend, int divisor) {
        // 特殊情况处理
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }
        if (dividend == 0) {
            return 0;
        }

        // 确定结果的符号
        int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;

        // 使用 long 类型以避免溢出
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long result = 0;

        // 通过减去最大倍数的除数来减少被除数
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // 找到最大的倍数
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // 更新被除数和结果
            absDividend -= tempDivisor;
            result += multiple;
        }

        // 处理结果符号和溢出
        result *= sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3)); // 输出: 3
        System.out.println(divide(-10, 3)); // 输出: -3
        System.out.println(divide(10, -3)); // 输出: -3
        System.out.println(divide(-10, -3)); // 输出: 3
        System.out.println(divide(-2147483648, -1)); // 溢出情况，输出: 2147483647
    }
}
