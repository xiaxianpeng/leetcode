package org.example.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 *
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 * @author xianpeng.xia
 * on 2022/4/11 9:53 AM
 */
public class FractionToDecimal {

    /**
     * 模拟竖式计算（除法）
     *
     * @param numerator 除数
     * @param denominator 被除数
     *
     * 两个数相除要么是「有限位小数」，要么是「无限循环小数」，而不可能是「无限不循环小数」。
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        // 转long计算，防止溢出
        long a = numerator, b = denominator;
        // 如果本身可以整除，返回计算结果
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuffer ans = new StringBuffer();
        // 如果其一是负数，先追加负号
        if (a * b < 0) {
            ans.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        // 计算小数点前的部分，并将余数赋值给a
        ans.append(String.valueOf(a / b) + ".");
        a = a % b;

        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            //  记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a, ans.length());
            // 对余数补0（乘10），再重新计算，由于不断补0，往后的过程取决与当前余数是多少，一旦之前出现，则说明产生了循环小数
            a *= 10;
            ans.append(a / b);
            a %= b;
            // 如果当前余数出现过，则将[出现位置 -> 当前位置]的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", ans.substring(0, u), ans.substring(u));
            }

        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int numerator = 4, denominator = 333;
        String fractionToDecimal = fractionToDecimal(numerator, denominator);
        System.out.println(fractionToDecimal);
    }
}
