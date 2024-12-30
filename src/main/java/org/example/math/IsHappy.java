package org.example.math;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * Created on 2024/12/30 23:34
 */
public class IsHappy {

    /**
     * 判断一个数是否为快乐数
     *
     * @param n 要判断的正整数
     * @return n是否为快乐数
     * 算法思路：
     * 使用快慢指针的方法检测循环，对于每一步，将数字替换为其各位数字的平方和
     * 如果最终结果为1，则是快乐数，如果进入循环(快慢指针相遇且不为1),则不是快乐数
     */
    public static boolean isHappy(int n) {
        // 初始化快慢指针
        int slow = n;
        int fast = getNext(n);
        System.out.println("初始值：slow = " + slow + ", fast = " + fast);
        // 快慢指针遍历
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);// 慢指针走一步
            fast = getNext(getNext(fast));// 快指针走两步
            System.out.println("更新后：slow = " + slow + ", fast = " + fast);
        }
        return fast == 1;
    }

    /**
     * 计算一个数各位数字的平方和
     *
     * @param num 输入的整数
     * @return 各位数字平方和
     */
    private static int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10;//获取最低位数
            totalSum += digit * digit;//累计平方
            num /= 10;//移除最低位数
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
