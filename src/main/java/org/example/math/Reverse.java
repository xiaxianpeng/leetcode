package org.example.math;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * Created on 2024/12/18 16:41
 */
public class Reverse {

    /**
     * 反转整数，并检查溢出
     *
     * @param x 输入的整数
     * @return 反转后的整数，溢出则返回0
     */
    public static int reverse(int x) {
        int result = 0;
        int sign = x < 0 ? -1 : 1;//记录符合
        x = Math.abs(x);//处理负数，取绝对值

        while (x != 0) {
            // 取出最后一位
            int digit = x % 10;
            // 更新x，去掉最后一位
            x /= 10;

            // Integer.MAX_VALUE = 2147483647
            // 检查是否溢出
            if (result > Integer.MAX_VALUE / 10 // 如果大于Integer.MAX_VALUE / 10，下一步*10就会溢出
                    || (result == Integer.MAX_VALUE / 10 && digit > 7)) {// 如果等于于Integer.MAX_VALUE / 10，再加上digit就会溢出
                return 0;
            }
            //将当前数字，加到结果末尾
            result = result * 10 + digit;
        }

        // 根据符号恢复负数
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
    }

}
