package org.example.string.twopointers;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，
 * 计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），
 * 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * Created on 2024/12/27 15:09
 */
public class AddStrings {
    /**
     * 字符串相加
     *
     * @param num1 第一个非负整数字符串
     * @param num2 第二个非负整数字符串
     * @return 两个字符串形式的和
     * 算法思路：
     * 从两个字符串的末尾开始逐位相加，考虑进位，直到所有位都处理完
     * 使用StringBuffer逆序存储结果，最后反转得到最终的和
     */
    public static String addStrings(String num1, String num2) {
        // 初始化指针i,j分别指向num1和num2的最后一个字符
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // 初始化进位变量carry和StringBuffer用来存储结果
        StringBuffer result = new StringBuffer();
        int carry = 0;

        // 开始逐位相加，直到所有位都处理完
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;// 当前位的和初始化为进位
            if (i >= 0) {
                // 将字符转化为整数并加入到sum中
                sum += Integer.valueOf(num1.charAt(i) - '0');
                // 移动指针i
                i--;
            }
            if (j >= 0) {
                // 将字符转化为整数并加入到sum中
                sum += Integer.valueOf(num2.charAt(j) - '0');
                // 移动指针j
                j--;
            }
            // 计算当前位的数字和新的进位
            result.append(sum % 10);
            carry = sum / 10;
        }

        // 反转得到正确的顺序
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));//134
        System.out.println(addStrings("456", "77"));//533
        System.out.println(addStrings("0", "0"));//0
    }
}
