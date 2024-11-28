package org.example.bit;

/**
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * *      ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 */
public class HammingDistance {

    /**
     * 使用位运算中移位的操作实现位计数
     */
    public static int hammingDistance(int x, int y) {
        // Step 1: 对x和y进行异或运算
        int xor = x ^ y;
        System.out.println("初始 x: " + Integer.toBinaryString(x) + " (二进制), " + x + " (十进制)");
        System.out.println("初始 y: " + Integer.toBinaryString(y) + " (二进制), " + y + " (十进制)");
        System.out.println("x ^ y = " + Integer.toBinaryString(xor) + " (二进制), " + xor + " (十进制)");
        // Step 2: 统计异或结果中1的个数
        int distance = 0;
        while (xor != 0) {
            System.out.println("当前 xor: " + Integer.toBinaryString(xor) + " (二进制), " + xor + " (十进制)");
            // 使用x & (x - 1)技巧消除最右边的1
            xor &= (xor - 1);
            // 每次消除一个1，计数器加1
            distance++;
            System.out.println("更新后 xor: " + Integer.toBinaryString(xor) + " (二进制), 距离 = " + distance);
        }

        // 返回汉明距离
        System.out.println("最终汉明距离: " + distance);
        return distance;
    }

    public static void main(String[] args) {
        //  x = 1, y = 4, 预期输出: 2
        System.out.println("1 和 4 之间的汉明距离: " + hammingDistance(1, 4));

        //  x = 3, y = 1, 预期输出: 1
        System.out.println("3 和 1 之间的汉明距离: " + hammingDistance(3, 1));

        // 15 的二进制是 1111，8 的二进制是 1000
        // 1111 XOR 1000 = 0111，有三个1，汉明距离为3
        System.out.println("15 和 8 之间的汉明距离: " + hammingDistance(15, 8));
    }
}
