package org.example.math;

/**
 * 1071. 字符串的最大公因子
 * 对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/17 22:50
 */
public class GreatestCommonDivisorOfStrings {

    /**
     * 算法思路：
     * 1、拼接验证：检查 str1 + str2 是否等于 str2 + str1，验证两个字符串是否有公共因子。
     * 如果不相等，直接返回 ""，表示无公共因子。
     * 2、辗转相除法计算公约数：使用字符串长度求出最大公约数gcd(len1,len2)。
     * 3、 提取公共因子：截取 str1 的前 gcd(len1,len2) 个字符作为最长公共因子。
     */
    public static String gcdOfStrings(String str1, String str2) {
        // 判断是否满足拼接等式
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 计算长度的最大公约数
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    // 使用辗转相除法计算最大公约数
    private static int gcd(int a, int b) {
        int reminder = a % b;
        while (reminder != 0) {
            a = b;
            b = reminder;
            reminder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC")); // 输出："ABC"
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); // 输出："AB"
        System.out.println(gcdOfStrings("LEET", "CODE"));   // 输出：""
    }
}
