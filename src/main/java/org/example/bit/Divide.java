package org.example.bit;

/**
 * @author xianpeng.xia
 * on 2022/4/8 10:32 PM
 * 除法
 */
public class Divide {

    /**
     * @param dividend 被除数
     * @param divisor 除数
     * @return 结果
     * 减法代替除法
     */
    public static int divide(int dividend, int divisor) {
        int sign = (((dividend ^ divisor) >> 31 & 0x1) == 1) ? -1 : 1;
        System.out.println("sign = " + sign);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int ret = 0;
        while (dividend >= divisor) {
            // 步长加倍
            int i = 1;
            long temp = divisor;

            while (dividend >= temp) {
                dividend -= temp;
                ret += i;
                i = i << 1;
                temp = temp << 1;
            }

        }
        ret *= sign;
        return ret;
    }

    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        int ret = divide(dividend, divisor);
        System.out.println(ret);
    }
}
